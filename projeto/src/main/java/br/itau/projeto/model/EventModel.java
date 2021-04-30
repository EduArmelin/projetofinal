package br.itau.projeto.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="itmn_evento")
public class EventModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="num_seq")
    private int numSeq;
    @Column(name="data_evt")
    private LocalDate dataEvt;
   
    @OneToOne
    @JoinColumn(name="id_alarme")
    private AlarmeModel alarme;

    @OneToOne
    @JoinColumn(name="id_equip")
    private EquipamentoModel equipamento;

    
    public AlarmeModel getAlarme() {
        return alarme;
    }
    public void setAlarme(AlarmeModel alarme) {
        this.alarme = alarme;
    }
    public EquipamentoModel getEquipamento() {
        return equipamento;
    }
    public void setEquipamento(EquipamentoModel equipamento) {
        this.equipamento = equipamento;
    }
    public int getNumSeq() {
        return numSeq;
    }
    public void setNumSeq(int numSeq) {
        this.numSeq = numSeq;
    }
    public LocalDate getDataEvt() {
        return dataEvt;
    }
    public void setDataEvt(LocalDate dataEvt) {
        this.dataEvt = dataEvt;
    }
    

}
