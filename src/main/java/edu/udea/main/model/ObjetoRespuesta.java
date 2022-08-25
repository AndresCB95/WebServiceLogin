package edu.udea.main.model;

public class ObjetoRespuesta {

    private String mensaje;
    private Object object;

    public ObjetoRespuesta(String mensaje, Object object) {
        this.mensaje = mensaje;
        this.object = object;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
