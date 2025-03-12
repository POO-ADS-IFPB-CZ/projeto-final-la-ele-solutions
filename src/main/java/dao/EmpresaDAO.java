package dao;

import model.negocio.Empresa;
import java.io.*;

public class EmpresaDAO {
    private static final String FILE_PATH = "empresa_db.dat";

    public void salvarEmpresa(Empresa empresa) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            out.writeObject(empresa);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Empresa carregarEmpresa() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (Empresa) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
