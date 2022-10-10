package com.eventoapp.Models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class Evento implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    @NotBlank
    private String nome;
    
    @NotBlank
    private String local;
    
    @NotBlank
    private String data;
    
    @NotBlank
    private String horario;

    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL, orphanRemoval=true)
    private List<Convidado> convidados;
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getLocal() {
        return local;
    }
    public void setLocal(String local) {
        this.local = local;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public String getHorario() {
        return horario;
    }
    public void setHorario(String horario) {
        this.horario = horario;
    }
    public long getCodigo() {
        return codigo;
    }
    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }
    public List<Convidado> getConvidados() {
        return convidados;
    }
    public void setConvidados(List<Convidado> convidados) {
        this.convidados = convidados;
    }
    
}
