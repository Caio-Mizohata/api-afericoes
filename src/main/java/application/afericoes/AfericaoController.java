package application.afericoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/afericoes")
public class AfericaoController {
    @Autowired
    private AfericaoService afericaoService;

    @GetMapping
    public Iterable<AfericaoDTO> getAll() {
        return afericaoService.getAll();
    }

    @GetMapping("/{id}")
    public AfericaoDTO getOne(@PathVariable long id) {
        return afericaoService.getOne(id);
    }

    @PostMapping
    public AfericaoDTO insert(@RequestBody AfericaoInsertDTO afericao) {
        return afericaoService.insert(afericao);
    }

    @PutMapping("/{id}")
    public AfericaoDTO update(@PathVariable long id, @RequestBody AfericaoInsertDTO afericao) {
        return afericaoService.update(id, afericao);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        afericaoService.delete(id);
    }
}
