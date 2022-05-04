/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author HP EliteBook 8470p
 */
public class ConsultasBD {
    MySQL baseDatos = new MySQL().conectar("localhost", "sistemadental","root", "");
    
    public void insertarPaciente (String nombres, String apellido_p,String apellido_m,
  Date fecha_nacimiento, String celular,String direccion, String estado, String municipio){
        String sql= "INSERT INTO pacientes VALUES (null,'"+nombres+"','"+apellido_p+"','"+apellido_m+"','"+fecha_nacimiento+"','"+celular+"','"+direccion+"','"+estado+"','"+municipio+"')";
        System.out.println(sql);
        
        if(baseDatos.ejecutar(sql)){
            System.out.println("Se ha insertado el dato");
        }
        else{System.out.println("Ocurrio un problema al insertar");
        
        }
    }
    public ArrayList<Paciente> consultarPaciente() {
        ArrayList<Paciente> result = new ArrayList<>();
        ResultSet rs = baseDatos.consultar("SELECT * FROM pacientes");
        if (rs != null) {
            try {
                while (rs.next()) {
                    result.add(new Paciente(
                            rs.getInt("id"),
                            rs.getString("nombres"),
                            rs.getString("apellido_P"),
                            rs.getString("apellido_M"),
                            rs.getDate("fechaDeNacimiento"),
                            rs.getString("direccion"),
                            rs.getString("estado"),
                            rs.getString("celular"),
                            rs.getString("municipio")
                    ));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    public void modificarPaciente (String celular,String direccion, String estado, String municipio,int id)
    {
        String sql ="UPDATE pacientes SET celular= '"+celular
                +"',direccion='" +direccion
                +"', estado= '" +estado 
		+"', municipio= '" +municipio 
                +"' where id="+id;
        if (baseDatos.ejecutar(sql)) {
            System.out.println("Ejecucion correcta");
        } else {
            System.out.println("Ocurrio un problema al modificar");
        }
               
    }

    public void borrarPaciente (int id)
    {
        if (baseDatos.ejecutar("DELETE FROM pacientes WHERE " 
                +"id="+id)) {
            System.out.println("Ejecucion correcta");
        } else {
            System.out.println("Ocurrio un problema al borrar");
        }
    }
    
    public Paciente buscarPorIdPaciente(int id) {
        Paciente paciente = null;
        ResultSet rs = baseDatos.consultar("SELECT * FROM pacientes "
                + " where id=" + id);
        if (rs != null) {
            try {
                while (rs.next()) {
                    paciente = new Paciente(
                            rs.getInt("id"),
                            rs.getString("nombres"),
                            rs.getString("apellido_P"),
                            rs.getString("apellido_M"),
                            rs.getDate("fechaDeNacimiento"),
                            rs.getString("celular"),
                            rs.getString("direccion"),
                            rs.getString("estado"),
                            rs.getString("municipio")
                    );
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return paciente;
    }
    
    public int buscarEstado (String estado) {

        int id = 0;
        String sql = "SELECT id FROM estados WHERE estado='"+estado+"'";
        try {
             ResultSet rs = baseDatos.consultar(sql);
             if(rs.next()){
             id=rs.getInt("id");
             }
             
        } catch (SQLException e) {
            
        }
        return id;
 }
 
    public String buscarMunicipio (String municipio) {

        String municipioN = "";
        String sql = "SELECT municipio FROM municipios WHERE municipio='"+municipio+"'";
        try {
             ResultSet rs = baseDatos.consultar(sql);
             if(rs.next()){
             municipioN=rs.getString("municipio");
             }
             
        } catch (SQLException e) {
            
        }
        return municipioN;
 }
    
    public void insertarEspecialista (String nombres, String apellido_p,String apellido_m, String direccion,String estado, String municipio, String celular){
        String sql= "INSERT INTO especialista VALUES (null,'"+nombres+"','"+apellido_p+"','"+apellido_m+"','"+direccion+"','"+estado+"','"+municipio+"','"+celular+"')";
        System.out.println(sql);
        
        if(baseDatos.ejecutar(sql)){
            System.out.println("Se ha insertado el dato");
        }
        else{System.out.println("Ocurrio un problema al insertar");
        
        }
    }
    public ArrayList<Especialista> consultarEspecialista() {
        ArrayList<Especialista> result = new ArrayList<>();
        ResultSet rs = baseDatos.consultar("SELECT * FROM especialista");
        if (rs != null) {
            try {
                while (rs.next()) {
                    result.add(new Especialista(
                            rs.getInt("id"),
                            rs.getString("nombres"),
                            rs.getString("apellido_P"),
                            rs.getString("apellido_M"),
                            rs.getString("direccion"),
                            rs.getString("estado"),
                            rs.getString("municipio"),
                            rs.getString("celular")
                    ));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    
    public void modificarEspecilista (String celular,String direccion, String estado, String municipio,int id)
    {
        String sql ="UPDATE especialista SET celular= '"+celular
                +"',direccion='" +direccion
                +"', estado= '" +estado 
		+"', municipio= '" +municipio 
                +"' where id="+id;
        if (baseDatos.ejecutar(sql)) {
            System.out.println("Ejecucion correcta");
        } else {
            System.out.println("Ocurrio un problema al modificar");
        }
               
    }

    public void borrarEspecialista (int id)
    {
        if (baseDatos.ejecutar("DELETE FROM especialista WHERE " 
                +"id="+id)) {
            System.out.println("Ejecucion correcta");
        } else {
            System.out.println("Ocurrio un problema al borrar");
        }
    }
      
    public Especialista buscarPorIdEspecialista(int id) {
        Especialista especialista = null;
        ResultSet rs = baseDatos.consultar("SELECT * FROM especialistas "
                + " where id=" + id);
        if (rs != null) {
            try {
                while (rs.next()) {
                    especialista = new Especialista(
                            rs.getInt("id"),
                            rs.getString("nombres"),
                            rs.getString("apellido_P"),
                            rs.getString("apellido_M"),
                            rs.getString("celular"),
                            rs.getString("direccion"),
                            rs.getString("estado"),
                            rs.getString("municipio")
                    );
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return especialista;
    }
    
    public void insertarMedicamento (String codigo, String medica_Name,String descripcion,int cant_Disponible, double precio_Unit){
        String sql= "INSERT INTO medicamento VALUES ('"+codigo+"','"+medica_Name+"','"+descripcion+"',"+cant_Disponible+","+precio_Unit+")";
        System.out.println(sql);
        
        if(baseDatos.ejecutar(sql)){
            System.out.println("Se ha insertado el dato");
        }
        else{System.out.println("Ocurrio un problema al insertar");
        
        }
    }
    
    public ArrayList<Medicamento> consultarMedicamento() {
        ArrayList<Medicamento> result = new ArrayList<>();
        ResultSet rs = baseDatos.consultar("SELECT * FROM medicamento");
        if (rs != null) {
            try {
                while (rs.next()) {
                    result.add(new Medicamento(
                            rs.getString("codigo"),
                            rs.getString("medica_Name"),
                            rs.getString("descripcion"),
                            rs.getInt("cant_Disponible"),
                            rs.getDouble("precio_Unit")
                    ));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    
    public void modificarMedicamento (String medica_Name, String descripcion, int cant_Disponible, double precio_Unit,String codigo)
    {
        String sql ="UPDATE medicamento SET medica_Name='" +medica_Name
                +"',descripcion= '"+descripcion
                +"',cant_Disponible=" +cant_Disponible
                +", precio_Unit= " +precio_Unit 
                +" where codigo='"+codigo+"'";
        if (baseDatos.ejecutar(sql)) {
            System.out.println("Ejecucion correcta");
        } else {
            System.out.println("Ocurrio un problema al modificar");
        }
               
    }

    public void borrarMedicamento (String codigo)
    {
        if (baseDatos.ejecutar("DELETE FROM medicamento WHERE " 
                +"codigo='"+codigo+"'")) {
            System.out.println("Ejecucion correcta");
        } else {
            System.out.println("Ocurrio un problema al borrar");
        }
    }
    
    public Medicamento buscarPorIdMedicamento(String codigo) {
    Medicamento medicamento = null;
    ResultSet rs = baseDatos.consultar("SELECT * FROM medicamento "
                + " where codigo='" + codigo+"'");
        if (rs != null) {
            try {
                while (rs.next()) {
                    medicamento = new Medicamento(
                          rs.getString("codigo"),
                            rs.getString("medica_Name"),
                            rs.getString("descripcion"),
                            rs.getInt("cant_Disponible"),
                            rs.getDouble("precio_Unit")
                    );
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        return medicamento;
    }
     public ArrayList<Medicamento> consultarMedicamentos(String codigo) {
        ArrayList<Medicamento> result = new ArrayList<>();
        ResultSet rs = baseDatos.consultar("SELECT * FROM medicamento where codigo= '"+ codigo+"'");
        if (rs != null) {
            try {
                while (rs.next()) {
                    result.add(new Medicamento(
                            rs.getString("codigo"),
                            rs.getString("medica_Name"),
                            rs.getString("descripcion"),
                            rs.getInt("cant_Disponible"),
                            rs.getDouble("precio_Unit")
                    ));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
          public ArrayList<Medicamento> consultarMedicamentosNombre(String nombre) {
        ArrayList<Medicamento> result = new ArrayList<>();
        ResultSet rs = baseDatos.consultar("SELECT * FROM medicamento where medica_Name= '"+ nombre+"'");
        if (rs != null) {
            try {
                while (rs.next()) {
                    result.add(new Medicamento(
                            rs.getString("codigo"),
                            rs.getString("medica_Name"),
                            rs.getString("descripcion"),
                            rs.getInt("cant_Disponible"),
                            rs.getDouble("precio_Unit")
                    ));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
          
    public void insertarServicio (String codigo, String server_Name, String descripcion){
        String sql= "INSERT INTO servicios VALUES ('"+codigo+"','"+server_Name+"','"+descripcion+"')";
        System.out.println(sql);
        
        if(baseDatos.ejecutar(sql)){
            System.out.println("Se ha insertado el dato");
        }
        else{System.out.println("Ocurrio un problema al insertar");
        
        }
    }
    
        public ArrayList<Servicio> consultarServicios() {
        ArrayList<Servicio> result = new ArrayList<>();
        ResultSet rs = baseDatos.consultar("SELECT * FROM Servicios");
        if (rs != null) {
            try {
                while (rs.next()) {
                    result.add(new Servicio(
                            rs.getString("codigo"),
                            rs.getString("server_Name"),
                            rs.getString("descripcion")
                    ));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
        
    public void modificarServicios (String codigo, String server_Name, String descripcion)
    {
        String sql ="UPDATE servicios SET server_Name= '" +server_Name
                +"', descripcion= '" +descripcion
                +"' where codigo= '"+codigo+"'";
        if (baseDatos.ejecutar(sql)) {
            System.out.println("Ejecucion correcta");
        } else {
            System.out.println("Ocurrio un problema al modificar");
        }
               
    }

    public void borrarServicios (String codigo)
    {
        if (baseDatos.ejecutar("DELETE FROM servicios WHERE " 
                +"codigo='"+codigo+"'")) {
            System.out.println("Ejecucion correcta");
        } else {
            System.out.println("Ocurrio un problema al borrar");
        }
    }   
    
    public Servicio buscarPorIdServicio(String codigo) {
    Servicio servicio = null;
    ResultSet rs = baseDatos.consultar("SELECT * FROM servicios "
                + " where codigo='" + codigo+"'");
        if (rs != null) {
            try {
                while (rs.next()) {
                    servicio = new Servicio(
                          rs.getString("codigo"),
                          rs.getString("server_Name"),
                          rs.getString("descripcion")
                    );
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return servicio;
    }
    
      public ArrayList<Servicio> consultarServicioCodigo(String codigo) {
        ArrayList<Servicio> result = new ArrayList<>();
        ResultSet rs = baseDatos.consultar("SELECT * FROM Servicios WHERE codigo ='"+codigo+"'");
        if (rs != null) {
            try {
                while (rs.next()) {
                    result.add(new Servicio(
                            rs.getString("codigo"),
                            rs.getString("server_Name"),
                            rs.getString("descripcion")
                    ));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

     public ArrayList<Servicio> consultarServicioNombre(String nombre) {
        ArrayList<Servicio> result = new ArrayList<>();
        ResultSet rs = baseDatos.consultar("SELECT * FROM Servicios WHERE server_Name='"+nombre+"'");
        if (rs != null) {
            try {
                while (rs.next()) {
                    result.add(new Servicio(
                            rs.getString("codigo"),
                            rs.getString("server_Name"),
                            rs.getString("descripcion")
                    ));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
     }
    
    public void insertarTratamiento (String codigo, String tratam_Name, String descripcion,double costo, String codigo_Servicio){
        String sql= "INSERT INTO tratamiento VALUES ('"+codigo+"','"+tratam_Name+"','"+descripcion+"',"+costo+",'"+codigo_Servicio+"')";
        System.out.println(sql);
        
        if(baseDatos.ejecutar(sql)){
            System.out.println("Se ha insertado el dato");
        }
        else{System.out.println("Ocurrio un problema al insertar");
        
        }
    }
    
    public ArrayList<Tratamiento> consultarTratamientos() {
        ArrayList<Tratamiento> result = new ArrayList<>();
        ResultSet rs = baseDatos.consultar("SELECT * FROM tratamiento");
        if (rs != null) {
            try {
                while (rs.next()) {
                    result.add(new Tratamiento(
                            rs.getString("codigo"),
                            rs.getString("tratam_Name"),
                            rs.getString("descripcion"),
                            rs.getDouble("costo"),
                            rs.getString("codigo_Servicio")
                    ));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    
    public void modificarTratamiento (String descripcion,double costo,String codigo)
    {
        String sql ="UPDATE tratamiento SET descripcion= '"+descripcion
                +", costo= " +costo
                +"' where codigo='"+codigo+"'";
        if (baseDatos.ejecutar(sql)) {
            System.out.println("Ejecucion correcta");
        } else {
            System.out.println("Ocurrio un problema al modificar");
        }
               
    }

    public void borrarTratamiento (String codigo)
    {
        if (baseDatos.ejecutar("DELETE FROM tratamiento WHERE " 
                +"codigo='"+codigo+"'")) {
            System.out.println("Ejecucion correcta");
        } else {
            System.out.println("Ocurrio un problema al borrar");
        }
    }   
    
    public Tratamiento buscarPorIdTratamiento(String codigo) {
    Tratamiento tratamiento = null;
    ResultSet rs = baseDatos.consultar("SELECT * FROM tratamientos "
                + " where codigo='" + codigo+"'");
        if (rs != null) {
            try {
                while (rs.next()) {
                    tratamiento = new Tratamiento(
                          rs.getString("codigo"),
                          rs.getString("tratam_Name"),
                          rs.getString("descripcion"),
                          rs.getDouble("costo"),
                          rs.getString("codigo_Servicio")
                    );
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return tratamiento;
    }
    
      public ArrayList<Tratamiento> consultarTratamientoCodigo(String codigo) {
        ArrayList<Tratamiento> result = new ArrayList<>();
        ResultSet rs = baseDatos.consultar("SELECT * FROM tratamiento WHERE codigo ='"+ codigo +"'");
        if (rs != null) {
            try {
                while (rs.next()) {
                    result.add(new Tratamiento(
                            rs.getString("codigo"),
                            rs.getString("tratam_Name"),
                            rs.getString("descripcion"),
                            rs.getDouble("costo"),
                            rs.getString("codigo_Servicio")
                    ));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public ArrayList<Tratamiento> consultarTratamientosNombre(String nombre) {
        ArrayList<Tratamiento> result = new ArrayList<>();
        ResultSet rs = baseDatos.consultar("SELECT * FROM tratamiento WHERE tratam_Name= '"+nombre+"'");
        if (rs != null) {
            try {
                while (rs.next()) {
                    result.add(new Tratamiento(
                            rs.getString("codigo"),
                            rs.getString("tratam_Name"),
                            rs.getString("descripcion"),
                            rs.getDouble("costo"),
                            rs.getString("codigo_Servicio")
                    ));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } 
        return result;
    }
    
    public void insertarAgenda (Date fecha, String horario, int id_Paciente, String turno){
        String sql= "INSERT INTO agenda VALUES (null,'"+fecha+"','"+horario+"', "+id_Paciente+",'"+turno+"','Vigente')";
        System.out.println(sql);
        
        if(baseDatos.ejecutar(sql)){
            System.out.println("Se ha insertado el dato");
        }
        else{System.out.println("Ocurrio un problema al insertar");
        
        }
    }
    
    public ArrayList<Agenda> consultarAgenda(String estado) {
        ArrayList<Agenda> result = new ArrayList<>();
        ResultSet rs = baseDatos.consultar("SELECT * FROM agenda WHERE estado = '"+estado+"'");
        if (rs != null) {
            try {
                while (rs.next()) {
                    result.add(new Agenda(
                            rs.getInt("id_Cita"),
                            rs.getDate("fecha"),
                            rs.getString("horario"),
                            rs.getInt("id_Paciente"),
                            rs.getString("turno")
                    ));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    
    public void anularCita ( int id_Cita)
    {
        String sql ="UPDATE agenda SET estado= 'Anulada' where id_Cita="+id_Cita;
        if (baseDatos.ejecutar(sql)) {
            System.out.println("Ejecucion correcta");
        } else {
            System.out.println("Ocurrio un problema al modificar");
        }
               
    }
    
    public void ActualizarEstadoAgenda (Date fecha)
    {
        String sql ="UPDATE agenda SET estado= 'Vencida'"
                +" where fecha < '"+fecha+"'";
        if (baseDatos.ejecutar(sql)) {
            System.out.println("Ejecucion correcta");
        } else {
            System.out.println("Ocurrio un problema al modificar");
        }
               
    }
    
    public void modificarAgenda (Date fecha,String horario, String turno,int id_Cita)
    {
        String sql ="UPDATE agenda SET fecha= '"+fecha
                +"', horario= '" +horario
                +"', turno= '" +turno
                +"' where id_Cita="+id_Cita;
        if (baseDatos.ejecutar(sql)) {
            System.out.println("Ejecucion correcta");
        } else {
            System.out.println("Ocurrio un problema al modificar");
        }
               
    }

    public void borrarAgenda (int id_Cita)
    {
        if (baseDatos.ejecutar("DELETE FROM agenda WHERE " 
                +"id_Cita="+id_Cita)) {
            System.out.println("Ejecucion correcta");
        } else {
            System.out.println("Ocurrio un problema al borrar");
        }
    }
    
    public Agenda buscarPorFechaAgenda(Date fecha) {
    Agenda agenda = null;
    ResultSet rs = baseDatos.consultar("SELECT * FROM agenda "
                + " where fecha='" + fecha+"'");
        if (rs != null) {
            try {
                while (rs.next()) {
                    agenda = new Agenda(
                          rs.getInt("id_Cita"),
                          rs.getDate("fecha"),
                          rs.getString("horario"),
                          rs.getInt("id_Paciente"),
                          rs.getString("turno")
                    );
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return agenda;
}
    
    public Agenda buscarPorIdAgenda(Date fecha, int id_Paciente) {
    Agenda agenda = null;
    ResultSet rs = baseDatos.consultar("SELECT * FROM agenda "+
"where fecha='"+fecha+"' AND id_Paciente= "+id_Paciente);
        if (rs != null) {
            try {
                while (rs.next()) {
                    agenda = new Agenda(
                          rs.getInt("id_Cita"),
                          rs.getDate("fecha"),
                          rs.getString("horario"),
                          rs.getInt("id_Paciente"),
                          rs.getString("turno")
                    );
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return agenda;
}
    
            public Agenda buscarPorIdAg(int id_C) {
    Agenda agenda = null;
    ResultSet rs = baseDatos.consultar("SELECT * FROM agenda "+
"where id_Cita= "+id_C);
        if (rs != null) {
            try {
                while (rs.next()) {
                    agenda = new Agenda(
                          rs.getInt("id_Cita"),
                          rs.getDate("fecha"),
                          rs.getString("horario"),
                          rs.getInt("id_Paciente"),
                          rs.getString("turno")
                    );
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return agenda;
}
     public ArrayList<Estado> consultarEstado() {
        ArrayList<Estado> result = new ArrayList<>();
        ResultSet rs = baseDatos.consultar("SELECT estado FROM estados");
        if (rs != null) {
            try {
                while (rs.next()) {
                    result.add(new Estado(
                            rs.getString("estado")
                    ));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    
    public ArrayList<Municipio> consultarMunicipio(int id_estado) {
        ArrayList<Municipio> result = new ArrayList<>();
        ResultSet rs = baseDatos.consultar("SELECT municipio FROM municipios where estado=" + id_estado + " ORDER BY municipio ASC");
        if (rs != null) {
            try {
                while (rs.next()) {
                    result.add(new Municipio(
                            rs.getString("municipio")
                    ));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public void insertarEspecialista(String nombre, String apellidoP, String apellidoM, Date date2, String celular, String direccion, String estado, String municipio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void modificarEspecialista(String celular, String direccion, String estado, String municipio, int claveElegida) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
        public void insertarUsuario (String usuario, String nombres,String apellidos,String contrasena, String rol){
        String sql= "INSERT INTO usuarios VALUES ('"+usuario
             +"','"+nombres+"','"+apellidos+"','"+contrasena
             +"','"+rol+"')";
        System.out.println(sql);
        
        if(baseDatos.ejecutar(sql)){
            System.out.println("Se ha inesrtado el dato");
        }
        else{System.out.println("Ocurrio un problema al insertar");
        
        }
    }
         public ArrayList<Usuario> consultarUsuarios() {
        ArrayList<Usuario> result = new ArrayList<>();
        ResultSet rs = baseDatos.consultar("SELECT * FROM usuarios");
        if (rs != null) {
            try {
                while (rs.next()) {
                    result.add(new Usuario(
                            rs.getString("usuario"),
                            rs.getString("nombres"),
                            rs.getString("apellidos"),
                            rs.getString("contrasena"),
                            rs.getString("rol")
                    ));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
         
                  public ArrayList<Usuario> consultarUsuarios_Tabla() {
        ArrayList<Usuario> result = new ArrayList<>();
        ResultSet rs = baseDatos.consultar("SELECT usuario,nombres,apellidos,rol FROM usuarios");
        if (rs != null) {
            try {
                while (rs.next()) {
                    result.add(new Usuario(
                            rs.getString("usuario"),
                            rs.getString("nombres"),
                            rs.getString("apellidos"),
                            rs.getString("rol")
                    ));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
                  
                  public ArrayList<Usuario> compararUsuario(String usuario, String contrasena) {
        ArrayList<Usuario> result = new ArrayList<>();
        ResultSet rs = baseDatos.consultar("SELECT usuario,nombres,apellidos,rol FROM usuarios");
        if (rs != null) {
            try {
                while (rs.next()) {
                    result.add(new Usuario(
                            rs.getString("usuario"),
                            rs.getString("nombres"),
                            rs.getString("apellidos"),
                            rs.getString("rol")
                    ));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
                  
    public Usuario comprobarUsuario(String usuario, String contrasena) {
        Usuario usuarios = null;
        ResultSet rs = baseDatos.consultar("SELECT * FROM usuarios "
                + " where usuario='" + usuario+"' AND contrasena= '"+contrasena+"'");
        if (rs != null) {
            try {
                while (rs.next()) {
                    usuarios = new Usuario(
                            rs.getString("usuario"),
                            rs.getString("nombres"),
                            rs.getString("apellidos"),
                            rs.getString("contrasena"),
                            rs.getString("rol")
                    );
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return usuarios;
    }
                  
    public void modificarUsuario (String nombres,String apellidos, String contrasena, String rol,String usuario)
    {
        String sql ="UPDATE usuario SET nombres= '"+nombres
                +"',apellidos='" +apellidos
                +"', contrasena= '" +contrasena 
		+"', rol= '" +rol 
                +"' where usuario= '"+usuario+"'";
        if (baseDatos.ejecutar(sql)) {
            System.out.println("Ejecucion correcta");
        } else {
            System.out.println("Ocurrio un problema al modificar");
        }
               
    }

    public void borrarUsuario (String usuario)
    {
        if (baseDatos.ejecutar("DELETE FROM usuarios WHERE " 
                +"usuario='"+usuario+"'")) {
            System.out.println("Ejecucion correcta");
        } else {
            System.out.println("Ocurrio un problema al borrar");
        }
    }
    
    public Usuario buscarPorUser(String usuario) {
        Usuario usuarios = null;
        ResultSet rs = baseDatos.consultar("SELECT * FROM usuarios "
                + " where usuario='" + usuario+"'");
        if (rs != null) {
            try {
                while (rs.next()) {
                    usuarios = new Usuario(
                            rs.getString("usuario"),
                            rs.getString("nombres"),
                            rs.getString("apellidos"),
                            rs.getString("contrasena"),
                            rs.getString("rol")
                    );
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return usuarios;
    }
    
    public int obtenerIdCita() throws SQLException{
        int id= 0;
       String sql = "SELECT MAX(id_Cita) FROM agenda";
             ResultSet rs = baseDatos.consultar(sql);
             if(rs.next()){
        id=rs.getInt(1);
             }
             
        id= id+1;
        return id;
    }


   public Agenda buscarPorFechaAgendaBoton(Date fecha, String horario, String turno) {
    Agenda agenda = null;
    ResultSet rs = baseDatos.consultar("SELECT * FROM agenda "
                + " where fecha='" + fecha+"' AND horario= '"+horario +"' AND turno= '"+ turno+"'");
        if (rs != null) {
            try {
                while (rs.next()) {
                    agenda = new Agenda(
                          rs.getInt("id_Cita"),
                          rs.getDate("fecha"),
                          rs.getString("horario"),
                          rs.getInt("id_Paciente"),
                          rs.getString("turno")
                    );
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return agenda;
}

     public ArrayList<Paciente> consultarPacientes(int codigo) {
        ArrayList<Paciente> result = new ArrayList<>();
        ResultSet rs = baseDatos.consultar("SELECT * FROM pacientes where id= "+ codigo+"");
        if (rs != null) {
            try {
                while (rs.next()) {
                    result.add(new Paciente(
                            rs.getInt("id"),
                            rs.getString("nombres"),
                            rs.getString("apellido_P"),
                            rs.getString("apellido_M"),
                            rs.getDate("fechaDeNacimiento"),
                            rs.getString("direccion"),
                            rs.getString("estado"),
                            rs.getString("celular"),
                            rs.getString("municipio")
                    ));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}