package br.itau.projeto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="itmn_equipamento")
public class EquipamentoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_equip;
    @Column(name="hostname", length = 50, nullable = false)
    private String hostname;
    @Column(name="ipaddr", length = 15, nullable = false)
    private String ipaddr;

    public int getId_equip() {
        return id_equip;
    }
    public void setId_equip(int id_equip) {
        this.id_equip = id_equip;
    }
    public String getHostname() {
        return hostname;
    }
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }
    public String getIpaddr() {
        return ipaddr;
    }
    public void setIpaddr(String ipaddr) {
        this.ipaddr = ipaddr;
    }



}
