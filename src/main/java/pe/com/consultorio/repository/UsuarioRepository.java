
package pe.com.consultorio.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.com.consultorio.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    @Query(value="select * from Usuario u where u.estado='1'",nativeQuery = true)
    List<Usuario> findAllCustom();
    
    @Query(value="select * from Usuario u where upper(u.nombre_usuario) like upper(:nombre) and u.estado='1'",nativeQuery = true)
    List<Usuario> findByName(@Param("nombre") String nombre);
    
    @Query(value="select * from Usuario u where upper(u.apellido_usuario) like upper(:apellido) and u.estado='1'",nativeQuery = true)
    List<Usuario> findBySurname(@Param("apellido") String apellido);
    
    @Query(value="select * from Usuario u where u.estado='0'",nativeQuery = true)
    List<Usuario> findAllInactive();
}
