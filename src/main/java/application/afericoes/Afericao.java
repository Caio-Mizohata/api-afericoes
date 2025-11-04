package application.afericoes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.GenerationType;


@Entity
@Table(name = "afericoes")
@Getter
@Setter
@NoArgsConstructor
public class Afericao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_sensor", nullable = false)
    private String id_sensor;

    @Column(name = "unidade", nullable = false)
    private String unidade;

    @Column(name = "valor", nullable = false)
    private String valor;
    
    public Afericao(AfericaoInsertDTO afericao) {
        this.setId_sensor(afericao.id_sensor());
        this.setUnidade(afericao.unidade());
        this.setValor(afericao.valor());
    }
}
