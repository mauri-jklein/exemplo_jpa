package educar.rs.exemplo_jpa.controller;

import educar.rs.exemplo_jpa.entity.Time;
import educar.rs.exemplo_jpa.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class TimeController {

    @Autowired
    private TimeService timeService;

    @PostMapping("time")
    public ResponseEntity<Time> salvarTime(@RequestBody Time time){
        return ResponseEntity.status(HttpStatus.CREATED).body(timeService.salvarTime(time));
    }

    @GetMapping("time/{id}")
    public ResponseEntity<Time> buscarTime(@PathVariable Long id){
        Time time = timeService.buscarTime(id);
        if(time==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado");
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(time);
        }
    }

    @GetMapping("times")
    public ResponseEntity<List<Time>> buscarTimes(){
        return ResponseEntity.status(HttpStatus.OK).body(timeService.buscarTimes());
    }

    @PutMapping("time")
    public ResponseEntity<Time> atualizarTime(@RequestBody Time time){
        return ResponseEntity.status(HttpStatus.OK).body(timeService.atualizarTime(time));
    }

    @DeleteMapping("time/{id}")
    public ResponseEntity<String> apagarTime(@PathVariable Long id) {
        try {
            timeService.apagarTime(id);
            return ResponseEntity.status(HttpStatus.OK).body("Time com id " + id + " excluído com sucesso!");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

}
