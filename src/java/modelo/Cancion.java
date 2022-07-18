/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Boris
 */
@Entity
@Table(name = "cancion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cancion.findAll", query = "SELECT c FROM Cancion c")
    , @NamedQuery(name = "Cancion.findByTitulo", query = "SELECT c FROM Cancion c WHERE c.titulo = :titulo")
    , @NamedQuery(name = "Cancion.findByAlbum", query = "SELECT c FROM Cancion c WHERE c.album = :album")
    , @NamedQuery(name = "Cancion.findByAnio", query = "SELECT c FROM Cancion c WHERE c.anio = :anio")
    , @NamedQuery(name = "Cancion.findByArtista", query = "SELECT c FROM Cancion c WHERE c.artista = :artista")})
public class Cancion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "titulo")
    private String titulo;
    @Size(max = 255)
    @Column(name = "album")
    private String album;
    @Size(max = 255)
    @Column(name = "anio")
    private String anio;
    @Size(max = 255)
    @Column(name = "artista")
    private String artista;
    @JoinColumn(name = "lista_nombre", referencedColumnName = "nombre")
    @ManyToOne
    private Lista listaNombre;

    public Cancion() {
    }

    public Cancion(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public Lista getListaNombre() {
        return listaNombre;
    }

    public void setListaNombre(Lista listaNombre) {
        this.listaNombre = listaNombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (titulo != null ? titulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cancion)) {
            return false;
        }
        Cancion other = (Cancion) object;
        if ((this.titulo == null && other.titulo != null) || (this.titulo != null && !this.titulo.equals(other.titulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Cancion[ titulo=" + titulo + " ]";
    }
    
}
