package application.afericoes;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;


@Service
public class AfericaoService {
    @Autowired
    private AfericaoRepository afericaoRepo;

    public Iterable<AfericaoDTO> getAll() {
        return afericaoRepo.findAll().stream().map(AfericaoDTO::new).toList();
    }

    public AfericaoDTO getOne(Long id) {
        Optional<Afericao> resultado = afericaoRepo.findById(id);

        if (resultado.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aferição não encontrada");
        }

        return new AfericaoDTO(resultado.get());
    }

    public AfericaoDTO insert(AfericaoInsertDTO afericao) {
        return new AfericaoDTO(afericaoRepo.save(new Afericao(afericao)));
    }

    public AfericaoDTO update(long id, AfericaoInsertDTO afericao) {
        Optional<Afericao> resultado = afericaoRepo.findById(id);

        if (resultado.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aferição não encontrada");
        }

        resultado.get().setId_sensor(afericao.id_sensor());
        resultado.get().setUnidade(afericao.unidade());
        resultado.get().setValor(afericao.valor());

        return new AfericaoDTO(afericaoRepo.save(resultado.get()));
    }

    public void delete(long id) {
        Optional<Afericao> resultado = afericaoRepo.findById(id);

        if (resultado.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aferição não encontrada");
        }

        afericaoRepo.deleteById(id);
    }
}
