package br.ufpb.dcx.comerciotech;

public enum TipoProduto {

    HARDWARE, PERIFERICO, TELAS, CONSOLE, COMPUTADOR, CELULAR;

    public String toString() {
        if (this.equals(HARDWARE)) return "Hardware";
        else if (this.equals(PERIFERICO)) return "Periféricos";
        else if (this.equals(TELAS)) return "TV's/Monitores";
        else if (this.equals(CONSOLE)) return "Consoles";
        else if (this.equals(COMPUTADOR)) return "Computadores/Notebooks";
        else if (this.equals(CELULAR)) return "Celulares";
        return null;
    }

    public static TipoProduto parseTipo(String tipo) {
        return switch (tipo) {
            case "Hardware" -> HARDWARE;
            case "Periféricos" -> PERIFERICO;
            case "TV's/Monitores" -> TELAS;
            case "Consoles" -> CONSOLE;
            case "Computadores/Notebooks" -> COMPUTADOR;
            case "Celulares" -> CELULAR;
            default -> null;
        };
    }
}
