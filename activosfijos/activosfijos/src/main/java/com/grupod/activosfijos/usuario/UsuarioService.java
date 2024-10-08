package com.grupod.activosfijos.usuario;

import com.grupod.activosfijos.area.AreaEntity;
import com.grupod.activosfijos.area.AreaRepository;
import com.grupod.activosfijos.config.JwtConfig;
import com.grupod.activosfijos.rol.RolEntity;
import com.grupod.activosfijos.rol.RolRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.grupod.activosfijos.utils.ResponseDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;
    private final AreaRepository areaRepository;
    private final JwtConfig jwtConfig;
    private final Logger logger = LoggerFactory.getLogger(UsuarioService.class);

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, RolRepository rolRepository, AreaRepository areaRepository, JwtConfig jwtConfig) {
        this.usuarioRepository = usuarioRepository;
        this.rolRepository = rolRepository;
        this.areaRepository = areaRepository;
        this.jwtConfig = jwtConfig;
    }

    public ResponseEntity<ResponseDto<UsuarioDto>> crearUsuario(UsuarioDto usuarioDto) {
        if (usuarioRepository.existsByCorreo(usuarioDto.getCorreo())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new ResponseDto<>(false, "El correo ya está registrado", null)
            );
        }

        String encodedPassword = BCrypt.hashpw(usuarioDto.getPassword(), BCrypt.gensalt());
        RolEntity rolEntity = rolRepository.findById(usuarioDto.getRolId())
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
        AreaEntity areaEntity = areaRepository.findById(usuarioDto.getAreaId())
                .orElseThrow(() -> new RuntimeException("Área no encontrada"));

        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setNombre(usuarioDto.getNombre());
        usuario.setApellidoPaterno(usuarioDto.getApellidoPaterno());
        usuario.setApellidoMaterno(usuarioDto.getApellidoMaterno());
        usuario.setCorreo(usuarioDto.getCorreo());
        usuario.setPassword(encodedPassword);
        usuario.setEstado(usuarioDto.isEstado());
        usuario.setTelefono(usuarioDto.getTelefono());
        usuario.setRolId(rolEntity);
        usuario.setArea(areaEntity);

        usuario = usuarioRepository.save(usuario);

        UsuarioDto responseDto = new UsuarioDto(
                usuario.getIdUsuario(),
                usuario.getNombre(),
                usuario.getApellidoPaterno(),
                usuario.getApellidoMaterno(),
                usuario.getCorreo(),
                usuario.getEstado(),
                usuario.getTelefono(),
                usuario.getRolId().getIdRol(),
                usuario.getArea().getIdArea()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(
                new ResponseDto<>(true, "Usuario creado con éxito", responseDto)
        );
    }

    public ResponseEntity<ResponseDto<String>> loginUsuario(String correo, String password) {
        Optional<UsuarioEntity> usuarioOpt = usuarioRepository.findByCorreo(correo);
        if (usuarioOpt.isEmpty()) {
            logger.warn("Intento de login fallido: correo no encontrado");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
                    new ResponseDto<>(false, "Credenciales incorrectas", null)
            );
        }
        UsuarioEntity usuario = usuarioOpt.get();
        if (!BCrypt.checkpw(password, usuario.getPassword())) {
            logger.warn("Intento de login fallido: contraseña incorrecta para el correo {}", correo);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
                    new ResponseDto<>(false, "Credenciales incorrectas", null)
            );
        }

        String token = jwtConfig.generateToken(usuario.getCorreo(), usuario.getIdUsuario(), usuario.getRolId().getIdRol());
        logger.info("Usuario {} ha iniciado sesión exitosamente", correo);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseDto<>(true, "Login exitoso", token)
        );
    }

    public ResponseEntity<ResponseDto<UsuarioDto>> actualizarUsuario(Integer id, UsuarioDto usuarioDto, String token) {
        String usernameFromToken = jwtConfig.extractUsername(token);
        logger.debug("Correo extraído del token: {}", usernameFromToken);
        logger.debug("Correo en el DTO: {}", usuarioDto.getCorreo());

        if (usernameFromToken == null || !usernameFromToken.equals(usuarioDto.getCorreo())) {
            logger.warn("Token inválido o usuario no autorizado");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
                    new ResponseDto<>(false, "Token inválido o usuario no autorizado", null)
            );
        }
        Optional<UsuarioEntity> usuarioOpt = usuarioRepository.findById(id);
        if (usuarioOpt.isEmpty()) {
            logger.warn("Usuario con ID {} no encontrado", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseDto<>(false, "Usuario no encontrado", null)
            );
        }

        UsuarioEntity usuario = usuarioOpt.get();
        usuario.setNombre(usuarioDto.getNombre());
        usuario.setApellidoPaterno(usuarioDto.getApellidoPaterno());
        usuario.setApellidoMaterno(usuarioDto.getApellidoMaterno());
        usuario.setCorreo(usuarioDto.getCorreo());
        usuario.setTelefono(usuarioDto.getTelefono());
        usuario.setEstado(usuarioDto.isEstado());

        if (usuarioDto.getRolId() != null) {
            RolEntity rolEntity = rolRepository.findById(usuarioDto.getRolId())
                    .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
            usuario.setRolId(rolEntity);
        }

        if (usuarioDto.getAreaId() != null) {
            AreaEntity areaEntity = areaRepository.findById(usuarioDto.getAreaId())
                    .orElseThrow(() -> new RuntimeException("Área no encontrada"));
            usuario.setArea(areaEntity);
        }

        usuario = usuarioRepository.save(usuario);
        UsuarioDto responseDto = new UsuarioDto(
                usuario.getIdUsuario(),
                usuario.getNombre(),
                usuario.getApellidoPaterno(),
                usuario.getApellidoMaterno(),
                usuario.getCorreo(),
                usuario.getEstado(),
                usuario.getTelefono(),
                usuario.getRolId().getIdRol(),
                usuario.getArea().getIdArea()
        );
        logger.info("Usuario con ID {} actualizado exitosamente", id);

        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseDto<>(true, "Usuario actualizado con éxito", responseDto)
        );
    }

    public ResponseEntity<ResponseDto<UsuarioDto>> getUsuarioById(Integer id, String token) {
        String usernameFromToken = jwtConfig.extractUsername(token);
        logger.debug("Correo extraído del token: {}", usernameFromToken);
        Optional<UsuarioEntity> usuarioOpt = usuarioRepository.findById(id);
        if (usuarioOpt.isEmpty()) {
            logger.warn("Usuario con ID {} no encontrado", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseDto<>(false, "Usuario no encontrado", null)
            );
        }
        UsuarioEntity usuario = usuarioOpt.get();
        UsuarioDto responseDto = new UsuarioDto(
                usuario.getIdUsuario(),
                usuario.getNombre(),
                usuario.getApellidoPaterno(),
                usuario.getApellidoMaterno(),
                usuario.getCorreo(),
                usuario.getEstado(),
                usuario.getTelefono(),
                usuario.getRolId().getIdRol(),
                usuario.getArea().getIdArea()
        );

        logger.info("Usuario con ID {} encontrado", id);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseDto<>(true, "Usuario encontrado con éxito", responseDto)
        );
    }

    public ResponseEntity<ResponseDto<List<UsuarioDto>>> getAllUsuarios(String token) {
        String usernameFromToken = jwtConfig.extractUsername(token);
        logger.debug("Correo extraído del token: {}", usernameFromToken);

        List<UsuarioEntity> usuarios = usuarioRepository.findAll();
        List<UsuarioDto> usuariosDto = usuarios.stream().map(usuario ->
                new UsuarioDto(
                        usuario.getIdUsuario(),
                        usuario.getNombre(),
                        usuario.getApellidoPaterno(),
                        usuario.getApellidoMaterno(),
                        usuario.getCorreo(),
                        usuario.getEstado(),
                        usuario.getTelefono(),
                        usuario.getRolId().getIdRol(),
                        usuario.getArea().getIdArea()
                )
        ).collect(Collectors.toList());

        logger.info("Todos los usuarios obtenidos");
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseDto<>(true, "Usuarios obtenidos con éxito", usuariosDto)
        );
    }

    public ResponseEntity<ResponseDto<String>> eliminarUsuario(Integer id, String token) {
        String usernameFromToken = jwtConfig.extractUsername(token);
        logger.debug("Correo extraído del token: {}", usernameFromToken);

        Optional<UsuarioEntity> usuarioOpt = usuarioRepository.findById(id);
        if (usuarioOpt.isEmpty()) {
            logger.warn("Usuario con ID {} no encontrado", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseDto<>(false, "Usuario no encontrado", null)
            );
        }

        usuarioRepository.deleteById(id);
        logger.info("Usuario con ID {} eliminado exitosamente", id);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseDto<>(true, "Usuario eliminado con éxito", null)
        );
    }
}
