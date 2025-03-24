package br.com.fiap.generator;

import br.com.fiap.annotations.Coluna;
import br.com.fiap.annotations.Tabela;

import java.lang.reflect.Field;

public class SqlGenerator {

    public static String gerarSelect(Class<?> clazz) {
        if (!clazz.isAnnotationPresent(Tabela.class)) {
            throw new IllegalArgumentException("A classe não está anotada com @Tabela");
        }

        Tabela tabela = clazz.getAnnotation(Tabela.class);
        return "SELECT * FROM " + tabela.nome() + ";";
    }

    public static String gerarSelectPorId(Object obj, Long id) {
        Class<?> clazz = obj.getClass();

        if (!clazz.isAnnotationPresent(Tabela.class)) {
            throw new IllegalArgumentException("A classe não está anotada com @Tabela");
        }

        Tabela tabela = clazz.getAnnotation(Tabela.class);
        String idColuna = null;

        for (Field f : clazz.getDeclaredFields()) {
            if (f.isAnnotationPresent(Coluna.class) && f.getName().equalsIgnoreCase("id")) {
                idColuna = f.getAnnotation(Coluna.class).nome();
                break;
            }
        }

        if (idColuna == null) {
            throw new IllegalArgumentException("A classe não possui um campo ID anotado com @Coluna");
        }

        return "SELECT * FROM " + tabela.nome() + " WHERE " + idColuna + " = " + id + ";";
    }

    public static String gerarInsert(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();

        if (!clazz.isAnnotationPresent(Tabela.class)) {
            throw new IllegalArgumentException("A classe não está anotada com @Tabela");
        }

        Tabela tabela = clazz.getAnnotation(Tabela.class);
        StringBuilder campos = new StringBuilder();
        StringBuilder valores = new StringBuilder();

        for (Field f : clazz.getDeclaredFields()) {
            f.setAccessible(true);
            if (f.isAnnotationPresent(Coluna.class)) {
                Coluna coluna = f.getAnnotation(Coluna.class);
                campos.append(coluna.nome()).append(", ");
                valores.append("'").append(f.get(obj)).append("', ");
            }
        }

        //Remover a última vírgula
        if (campos.length() > 2) {
            campos.setLength(campos.length() - 2);
            valores.setLength(valores.length() - 2);
        }
        return "INSERT INTO " + tabela.nome() + " (" + campos + ") VALUES (" + valores + ");";
    }

    public static String gerarUpdate(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();

        if (!clazz.isAnnotationPresent(Tabela.class)) {
            throw new IllegalArgumentException("A classe não está anotada com @Tabela");
        }

        Tabela tabela = clazz.getAnnotation(Tabela.class);
        StringBuilder setClause = new StringBuilder();
        String idColuna = null;
        String idValor = null;

        for (Field f : clazz.getDeclaredFields()) {
            f.setAccessible(true);
            if (f.isAnnotationPresent(Coluna.class)) {
                Coluna coluna = f.getAnnotation(Coluna.class);
                if (f.getName().equalsIgnoreCase("id")) {
                    idColuna = coluna.nome();
                    idValor = f.get(obj).toString();
                } else {
                    setClause.append(coluna.nome()).append(" = '").append(f.get(obj)).append("', ");
                }
            }
        }

        //Remover a última vírgula
        if (setClause.length() > 2) {
            setClause.setLength(setClause.length() - 2);
        }
        return "UPDATE " + tabela.nome() + " SET " + setClause + " WHERE " + idColuna + " = " + idValor + ";";
    }

    public static String gerarDelete(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();

        if (!clazz.isAnnotationPresent(Tabela.class)) {
            throw new IllegalArgumentException("A classe não está anotada com @Tabela");
        }

        Tabela tabela = clazz.getAnnotation(Tabela.class);
        String idColuna = null;
        String idValor = null;

        for (Field f : clazz.getDeclaredFields()) {
            f.setAccessible(true);
            if (f.isAnnotationPresent(Coluna.class) && f.getName().equalsIgnoreCase("id")) {
                idColuna = f.getAnnotation(Coluna.class).nome();
                idValor = f.get(obj).toString();
                break;
            }
        }

        return "DELETE FROM " + tabela.nome() + " WHERE " + idColuna + " = " + idValor + ";";
    }
}
