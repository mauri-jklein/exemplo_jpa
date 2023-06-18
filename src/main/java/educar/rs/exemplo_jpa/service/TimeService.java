package educar.rs.exemplo_jpa.service;


import educar.rs.exemplo_jpa.entity.Time;

import educar.rs.exemplo_jpa.repository.TimeRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeService {

    @Autowired
    private TimeRepository timeRepository;

    public Time salvarTime(Time time){
        return timeRepository.save(time);
    }

    public Time buscarTime(Long id){
        return timeRepository.findById(id).get();
    }

    public List<Time> buscarTimes(){
        return timeRepository.findAll();
    }

    public Time atualizarTime(Time time){
        return timeRepository.save(time);
    }

    public void apagarTime(Long id){
        if(timeRepository.existsById(id)) {
            timeRepository.deleteById(id);
        }else {
            throw new RuntimeException("Time não encontrado");
        }
    }


}
