package com.mycompany.clasesargprogramar;

import java.io.IOException;

public abstract interface Metodos {
    public abstract void operacionesFile(String operacion) throws IOException;
    public abstract StringBuilder borrarCorchetes(StringBuilder entrada);
    public abstract String[] borrarCorchetesArray(String[] texto);
}
