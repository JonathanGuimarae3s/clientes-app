package app.modelo.meusclientes.datamodel;

public class ClienteDataModel {

    // Modelo Objeto Relacional

    // Toda Classe Data Model tem esta estrutura

    // 5 - Queries de consulta gerais

    // 1 - Atributo nome da tabela
    public static final String TABELA = "cliente";

    // 2 - Atributos um para um com os nomes dos campos

    public static final String ID = "id"; // integer
    public static final String NOME = "nome"; // text
    public static final String EMAIL = "email"; // text
    public static final String TELEFONE = "telefone"; // text
    public static final String LOGRADOURO = "logradouro"; // text
    public static final String NUMERO = "numero"; // text
    public static final String BAIRRO = "bairro"; // text
    public static final String CIDADE = "cidade"; // text
    public static final String ESTADO = "estado"; // text
    public static final String CEP = "cep"; // text
    public static final String TERMO_USO = "termoUso"; // integer

    // 3 - Query para criar a tabela no banco de dados
    public static String queryCriarTabela = "";

    // // 4 - Método para gerar o Script para criar a tabela;

    public static String criarTabela() {

        // Concatenação de String

        queryCriarTabela += "CREATE TABLE " + TABELA + " (";
        queryCriarTabela += ID + " INTEGER PRIMARY KEY AUTOINCREMENT, ";
        queryCriarTabela += NOME + " TEXT, ";
        queryCriarTabela += EMAIL + " TEXT, ";
        queryCriarTabela += TELEFONE + " TEXT, ";
        queryCriarTabela += LOGRADOURO + " TEXT, ";
        queryCriarTabela += NUMERO + " TEXT, ";
        queryCriarTabela += BAIRRO + " TEXT, ";
        queryCriarTabela += CIDADE + " TEXT, ";
        queryCriarTabela += ESTADO + " TEXT, ";
        queryCriarTabela += CEP + " TEXT, ";
        queryCriarTabela += TERMO_USO + " INTEGER ";
        queryCriarTabela += ")";

        // queryCriarTabela = "Parte 01 Parte 02 Parte 03 Parte 04"

        return queryCriarTabela;
    }

}
