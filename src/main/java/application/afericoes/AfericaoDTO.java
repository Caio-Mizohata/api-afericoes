package application.afericoes;

public record AfericaoDTO(long id, String id_sensor, String unidade, String valor) {
    public AfericaoDTO(Afericao afericao) {
        this(afericao.getId(), afericao.getId_sensor(), afericao.getUnidade(), afericao.getValor());
    }
}
