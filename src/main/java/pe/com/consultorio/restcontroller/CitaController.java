
package pe.com.consultorio.restcontroller;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.consultorio.entity.Cita;
import pe.com.consultorio.service.CitaService;


@RestController
@RequestMapping("/cita")
public class CitaController {
    
    @Autowired
    private CitaService citaService;
    
    @GetMapping
    public List<Cita> findAll(){
        return citaService.findAll();
    }
    
    @GetMapping("/custom")
    public List<Cita> findAllCustom(){
        return citaService.findAllCustom();
    }
    
    @GetMapping("/inactive")
    public List<Cita> findAllInactive(){
        return citaService.findAllInactive();
    }
    @GetMapping("/date/{date}")
    public List<Cita> findByName(@PathVariable Date date){
        return citaService.findbyDate(date);
    }
    @GetMapping("/{id}")
    public Optional<Cita> findById(@PathVariable long id){
        return citaService.findById(id);
    }
    @PostMapping //agrega la fecha un dia antes
    public Cita add(@RequestBody Cita c){
        return citaService.add(c);
    }
    @PutMapping("/{id}")
    public Cita update(@PathVariable Long id, @RequestBody Cita c){
        c.setCodigo(id);
        return citaService.update(c);
    }
    @DeleteMapping("/{id}")
    public Cita delete(@PathVariable Long id){
        Cita objCita = new Cita();
        objCita.setCodigo(id);
        return citaService.delete(Cita.builder().codigo(id).build());
    }
    
}
