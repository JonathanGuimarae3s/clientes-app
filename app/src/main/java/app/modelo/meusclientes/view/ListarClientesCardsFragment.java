package app.modelo.meusclientes.view;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import app.modelo.meusclientes.controller.ClienteController;
import app.modelo.meusclientes.model.Cliente;


public class ListarClientesCardsFragment extends Fragment {

    // Fragment - Classe responsável pela camada de VISÃO (Layout)
    View view;

    TextView txtItemLista;
    TextView txtTitulo;
    EditText editPesquisarNome;
    ListView listView;
    ArrayAdapter<String> clienteAdapter;

    ArrayList<HashMap<String, String>> filtroClientes;
    List<Cliente> clienteList;
    List<String> clientes = new ArrayList<>();
    ClienteController clienteController;
    Cliente cliente;


    public ListarClientesCardsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_listar_clientes_cards, container, false);

        TextView txtTitulo = view.findViewById(R.id.txtTitulo);

        txtTitulo.setText(R.string.listar_cliente_cards);

        // Trocar a cor da propriedade texto (setTextColor)
        txtTitulo.setTextColor(ColorStateList.valueOf(Color.YELLOW));

        clienteController = new ClienteController(getContext());

        listView = (ListView) view.findViewById(R.id.listView);

        editPesquisarNome = view.findViewById(R.id.editPesquisarNome);

        clienteList = clienteController.listar();
        
        clientes = clienteController.gerarListaDeClientesListView();

        clienteAdapter = new ArrayAdapter<>(getContext(), R.layout.listar_cliente_item, R.id.txtItemLista, clientes);

        listView.setAdapter(clienteAdapter);

        editPesquisarNome.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence texto, int start, int count, int after) {
                ListarClientesCardsFragment.this.clienteAdapter.getFilter().filter(texto);

                Log.i("add_ListView", "beforeTextChanged" + texto);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        return view;
    }


}
