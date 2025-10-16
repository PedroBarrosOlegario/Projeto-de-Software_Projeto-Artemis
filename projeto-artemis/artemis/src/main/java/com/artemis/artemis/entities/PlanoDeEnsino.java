package com.artemis.artemis.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_plano_ensino")
public class PlanoDeEnsino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String ementa;
    private String objetivo;
    private String conteudo;


    private String referenciaBasica1;
    private String referenciaBasica2;
    private String referenciaBasica3;
    private String referenciaBasica4;
    private String referenciaBasica5;


    private String referenciaComplementar1;
    private String referenciaComplementar2;
    private String referenciaComplementar3;
    private String referenciaComplementar4;
    private String referenciaComplementar5;
    private String referenciaComplementar6;
    private String referenciaComplementar7;
    private String referenciaComplementar8;
    private String referenciaComplementar9;
    private String referenciaComplementar10;

    @OneToOne
    @JoinColumn(name = "disciplina_id")
    private Disciplina disciplina;
    
    public PlanoDeEnsino() {
    }

    public PlanoDeEnsino(Integer id, String ementa, String objetivo, String conteudo) {
        this.id = id;
        this.ementa = ementa;
        this.objetivo = objetivo;
        this.conteudo = conteudo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getReferenciaBasica1() {
        return referenciaBasica1;
    }

    public void setReferenciaBasica1(String referenciaBasica1) {
        this.referenciaBasica1 = referenciaBasica1;
    }

    public String getReferenciaBasica2() {
        return referenciaBasica2;
    }

    public void setReferenciaBasica2(String referenciaBasica2) {
        this.referenciaBasica2 = referenciaBasica2;
    }

    public String getReferenciaBasica3() {
        return referenciaBasica3;
    }

    public void setReferenciaBasica3(String referenciaBasica3) {
        this.referenciaBasica3 = referenciaBasica3;
    }

    public String getReferenciaBasica4() {
        return referenciaBasica4;
    }

    public void setReferenciaBasica4(String referenciaBasica4) {
        this.referenciaBasica4 = referenciaBasica4;
    }

    public String getReferenciaBasica5() {
        return referenciaBasica5;
    }

    public void setReferenciaBasica5(String referenciaBasica5) {
        this.referenciaBasica5 = referenciaBasica5;
    }

    public String getReferenciaComplementar1() {
        return referenciaComplementar1;
    }

    public void setReferenciaComplementar1(String referenciaComplementar1) {
        this.referenciaComplementar1 = referenciaComplementar1;
    }

    public String getReferenciaComplementar2() {
        return referenciaComplementar2;
    }

    public void setReferenciaComplementar2(String referenciaComplementar2) {
        this.referenciaComplementar2 = referenciaComplementar2;
    }

    public String getReferenciaComplementar3() {
        return referenciaComplementar3;
    }

    public void setReferenciaComplementar3(String referenciaComplementar3) {
        this.referenciaComplementar3 = referenciaComplementar3;
    }

    public String getReferenciaComplementar4() {
        return referenciaComplementar4;
    }

    public void setReferenciaComplementar4(String referenciaComplementar4) {
        this.referenciaComplementar4 = referenciaComplementar4;
    }

    public String getReferenciaComplementar5() {
        return referenciaComplementar5;
    }

    public void setReferenciaComplementar5(String referenciaComplementar5) {
        this.referenciaComplementar5 = referenciaComplementar5;
    }

    public String getReferenciaComplementar6() {
        return referenciaComplementar6;
    }

    public void setReferenciaComplementar6(String referenciaComplementar6) {
        this.referenciaComplementar6 = referenciaComplementar6;
    }

    public String getReferenciaComplementar7() {
        return referenciaComplementar7;
    }

    public void setReferenciaComplementar7(String referenciaComplementar7) {
        this.referenciaComplementar7 = referenciaComplementar7;
    }

    public String getReferenciaComplementar8() {
        return referenciaComplementar8;
    }

    public void setReferenciaComplementar8(String referenciaComplementar8) {
        this.referenciaComplementar8 = referenciaComplementar8;
    }

    public String getReferenciaComplementar9() {
        return referenciaComplementar9;
    }

    public void setReferenciaComplementar9(String referenciaComplementar9) {
        this.referenciaComplementar9 = referenciaComplementar9;
    }

    public String getReferenciaComplementar10() {
        return referenciaComplementar10;
    }

    public void setReferenciaComplementar10(String referenciaComplementar10) {
        this.referenciaComplementar10 = referenciaComplementar10;
    }
    
    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
}
