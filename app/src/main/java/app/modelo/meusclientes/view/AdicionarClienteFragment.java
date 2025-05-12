package app.modelo.meusclientes.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import app.modelo.meusclientes.controller.ClienteController;
import app.modelo.meusclientes.model.Cliente;


public class AdicionarClienteFragment extends Fragment {

    // Fragment - Classe responsável pela camada de VISÃO (Layout)
    View view;

    TextView txtTitulo;

    EditText editNomeCompleto;
    EditText editTelefone;
    EditText editEmail;
    EditText editCep;
    EditText editLogradouro;
    EditText editNumero;
    EditText editBairro;
    EditText editCidade;
    EditText editEstado;

    CheckBox chkTermosUso;

    Button btnCancelar;
    Button btnSalvar;

    Cliente cliente;
    ClienteController clienteController;

    public AdicionarClienteFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_adicionar_cliente, container, false);

        iniciarComponentesLayout();

        escutarEnventosBotoes();

        return view;
    }

    private void iniciarComponentesLayout() {

        txtTitulo = view.findViewById(R.id.txtTitulo);

        editNomeCompleto = view.findViewById(R.id.editNomeCompleto);
        editTelefone = view.findViewById(R.id.editTelefone);
        editEmail = view.findViewById(R.id.editEmail);
        editCep = view.findViewById(R.id.editCep);
        editLogradouro = view.findViewById(R.id.editLogradouro);
        editNumero = view.findViewById(R.id.editNumero);
        editBairro = view.findViewById(R.id.editBairro);
        editCidade = view.findViewById(R.id.editCidade);
        editEstado = view.findViewById(R.id.editEstado);

        chkTermosUso = view.findViewById(R.id.chkTermosUso);

        btnCancelar = view.findViewById(R.id.btnCancelar);
        btnSalvar = view.findViewById(R.id.btnSalvar);


        txtTitulo.setText(R.string.adicionar_novo_cliente);

        cliente = new Cliente();
        clienteController = new ClienteController(getContext());

    }

    private void escutarEnventosBotoes() {

        btnCancelar.setOnClickListener(v -> {

        });

        btnSalvar.setOnClickListener(v -> {

            boolean isDadosOK = true;
            if(TextUtils.isEmpty(editNomeCompleto.getText())){
                isDadosOK = false;
                editNomeCompleto.setError("Digite o nome completo...");
                editNomeCompleto.requestFocus();
            }

            if(TextUtils.isEmpty(editTelefone.getText())){
                isDadosOK = false;
                editTelefone.setError("Digite o telefone...");
                editTelefone.requestFocus();
            }

            if(TextUtils.isEmpty(editEmail.getText())){
                isDadosOK = false;
                editEmail.setError("Digite o email...");
                editEmail.requestFocus();
            }

            if(TextUtils.isEmpty(editCep.getText())){
                isDadosOK = false;
                editCep.setError("Digite o cep...");
                editCep.requestFocus();
            }

            if(TextUtils.isEmpty(editLogradouro.getText())){
                isDadosOK = false;
                editLogradouro.setError("Digite o logradouro (av, rua...)");
                editLogradouro.requestFocus();
            }

            if(TextUtils.isEmpty(editNumero.getText())){
                isDadosOK = false;
                editNumero.setError("Digite o número...");
                editNumero.requestFocus();
            }

            if(TextUtils.isEmpty(editBairro.getText())){
                isDadosOK = false;
                editBairro.setError("Digite o bairro...");
                editBairro.requestFocus();
            }

            if(TextUtils.isEmpty(editCidade.getText())){
                isDadosOK = false;
                editCidade.setError("Digite a cidade...");
                editCidade.requestFocus();
            }

            if(TextUtils.isEmpty(editEstado.getText())){
                isDadosOK = false;
                editEstado.setError("Digite o estado (UF)");
                editEstado.requestFocus();
            }


            if (isDadosOK) {

                cliente.setNome(editNomeCompleto.getText().toString());
                cliente.setTelefone(editTelefone.getText().toString());
                cliente.setEmail(editEmail.getText().toString());
                cliente.setCep(Integer.parseInt(editCep.getText().toString()));
                cliente.setLogradouro(editLogradouro.getText().toString());
                cliente.setNumero(editNumero.getText().toString());
                cliente.setBairro(editBairro.getText().toString());
                cliente.setCidade(editCidade.getText().toString());
                cliente.setEstado(editEstado.getText().toString());

                clienteController.incluir(cliente);

                Log.i("log_add_cliente", "escutarEnventosBotoes(SALVAR): DADOS CORRETOS");

            } else {
                Log.i("log_add_cliente", "escutarEnventosBotoes(SALVAR): DADOS INCORRETOS");
            }

        });
    }


}
