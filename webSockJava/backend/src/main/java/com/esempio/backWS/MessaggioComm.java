package com.esempio.backWS;

public class MessaggioComm {

    private String provenienza;
    private int id;
    private String contenuto;

    public int getId() {
        return id;
    }

    public String getProvenienza(){
        return provenienza;
    }

    public String getContenuto(){
        return contenuto;
    }

    public void setID(int id){
        this.id = id;
    }


    public void setProvenienza(String provenienza){
        this.provenienza = provenienza;
    }

    public void setContenuto(String contenuto) {
        this.contenuto = contenuto;
    }

    @Override
    public String toString(){
        return "MessaggioComm{" +
                "provenienza='" + provenienza + '\'' +
                ", id=" + id +
                ", contenuto='" + contenuto + '\'' +
                '}';
    }

}

