/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.postresYa.model;


import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


/**
 *
 * @author Diego Alejandro Rodriguez Cruz
 */

@Entity
@Table (name = "Pedido")
    public class Pedido implements java.io.Serializable{
    
    /**
     * Declaracion de variables
     */
    private List <PostreCant> postres;
    private Date fecha;
    private String direccion; // Posibilidad de un objeto
    private int codigo;
    private String estado;
    private int precio;
    private Cliente cliente;

   

    /**
     * Constructor inicial de pedido
*/
    public Pedido(){
    
    }
    
    /**
     * Constructor con parametro de un pedido
     * @param postres  Lista de los postres que se solicitdan y su cantidad
     * @param direccion Direccion a la cual se solicito un postre
     * @param fecha Fecha de pedido en la que se realizo, para dar mayor prioridad a la mas antigua
     * @param estado
     * @param precio
     * @param cliente
     */
    public Pedido(List <PostreCant> postres, String direccion, Date fecha,String estado,int precio,Cliente cliente){
        
        this.postres = postres;
        this.fecha = fecha;
        this.direccion = direccion;
        this.estado=estado;
        this.precio=precio;
        this.cliente=cliente;
      
        
        
    }
        
    /**
     * Constructor con parametro de un pedido, sin los postres
     * @param direccion Direccion a la cual se solicito un postre
     * @param fecha Fecha de pedido en la que se realizo, para dar mayor prioridad a la mas antigua
     * @param estado
     * @param precio
     * @param cliente
     */
    public Pedido( String direccion, Date fecha,String estado,int precio,Cliente cliente){
        
       
        this.fecha = fecha;
        this.direccion = direccion;
        this.estado=estado;
        this.precio=precio;
        this.cliente=cliente;
      
        
        
    }
   
    
    /**
     * Metodo que retorna el precio del pedido
     * @return el precio del pedido
     */
      @Column(name = "precio" )
    public int getPrecio() {
        return precio;
    }
    
    /**
     * Cambia el precio del pedido
     * @param precio nuevo precio del pedido
     */
    public void setPrecio(int precio){
        this.precio=precio;
    }

    
     /**
      * Se obtiene la lista de postres solicitados, con sus cantitades
      * @return los postres que estan en el pedido
      */
    @OneToMany(cascade = CascadeType.ALL)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name="Pedido_id_pedido")
    public List<PostreCant> getPostres() {
        return postres;
    }
    
    public void setPostres(List<PostreCant> postres){
        this.postres=postres;
    }

    /**
     * Se obtiene la fecha de solicitud del pedido
     * @return fecha de aprobacion del pedido
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_aprobacion" )
    public Date getFecha() {
        
        return fecha;
    }
    
   public void setFecha(Date fecha) {
       this.fecha=fecha;
   }

    /**
     * Se obtiene la direccion a donde se requiere entregar el postre
     * @return la direccion de la entrega del pedido
     */
        @Column(name = "direccion" )
    public String getDireccion() {
        return direccion;
    }
    
    /**
     * 
     * @param dir  la direccion de entrega del pedido
     */
    public void setDireccion(String dir){
        this.direccion=dir;
    }

    /**
     * Codigo de pedido, para realizar las modificaciones necesarias para este
     * @return el id del pedido
     */
    @Id 
    @GeneratedValue
    @Column(name="id_pedido")
    public int getCodigo() {
        return codigo;
    }
    
    /**
     * 
     * @param cod  el id del pedido
     */
    public void setCodigo(int cod){
        this.codigo=cod;
    }
    
    /**
     * Maneja el estado del pedido
     * @param estado que se le va a poner al pedido
     */
    public void setEstado(String estado){

        this.estado=estado;
    }
    

    /**
     * Obtiene el estado del pedido
     * @return String con el estado del pedido
     */
    
    @Column(name="estado")
    public String getEstado(){
        return estado;
    }
    
    
     /**
     * obtiene el cliente
     * @return 
     */
    @ManyToOne()
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "Cliente_cedula", nullable = false)
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * asigna un cliente al pedido
     * @param cliente 
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


   
    
}
