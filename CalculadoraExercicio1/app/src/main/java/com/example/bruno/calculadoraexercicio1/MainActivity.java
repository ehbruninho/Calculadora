package com.example.bruno.calculadoraexercicio1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity implements OnClickListener{
    TextView txtResultado;
    TextView txtOperacao;

    //Efetua as operacoes
    public double op1,op2;

    //Armazena operacao
    public String op;

    //Teclado numerico
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0;

    //Teclado operacional
    Button btMais, btMenos,btDivid, btX,btIgual,btLimpa;

    //Botao numero decimal
    Button btPonto;


    public void inicializar(){
        txtResultado = (TextView)findViewById(R.id.txtResultado);
        txtOperacao  = (TextView)findViewById(R.id.txtOperacao);

        b1 = (Button)findViewById(R.id.b1);
        b2 = (Button)findViewById(R.id.b2);
        b3 = (Button)findViewById(R.id.b3);
        b4 = (Button)findViewById(R.id.b4);
        b5 = (Button)findViewById(R.id.b5);
        b6 = (Button)findViewById(R.id.b6);
        b7 = (Button)findViewById(R.id.b7);
        b8 = (Button)findViewById(R.id.b8);
        b9 = (Button)findViewById(R.id.b9);
        b0 = (Button)findViewById(R.id.b0);
        btX = (Button) findViewById(R.id.btX);
        btMais = (Button)findViewById(R.id.btMais);
        btMenos = (Button)findViewById(R.id.btMenos);
        btDivid = (Button)findViewById(R.id.btDivid);
        btIgual = (Button)findViewById(R.id.btIgual);
        btLimpa = (Button)findViewById(R.id.btClear);
        btPonto = (Button)findViewById(R.id.btPonto);

    }
        public void Listener(){
            b1.setOnClickListener((OnClickListener) this);
            b2.setOnClickListener((OnClickListener) this);
            b3.setOnClickListener((OnClickListener) this);
            b4.setOnClickListener((OnClickListener) this);
            b5.setOnClickListener((OnClickListener) this);
            b6.setOnClickListener((OnClickListener) this);
            b7.setOnClickListener((OnClickListener) this);
            b8.setOnClickListener((OnClickListener) this);
            b9.setOnClickListener((OnClickListener) this);
            b0.setOnClickListener((OnClickListener) this);
            btX.setOnClickListener((OnClickListener) this);
            btMais.setOnClickListener((OnClickListener) this);
            btMenos.setOnClickListener((OnClickListener) this);
            btDivid.setOnClickListener((OnClickListener) this);
            btLimpa.setOnClickListener((OnClickListener) this);
            btPonto.setOnClickListener((OnClickListener) this);
            btIgual.setOnClickListener((OnClickListener) this);

        }
            //Indentificar numeros
            public void tecladoNum(int lerNum){
                if(txtOperacao.getText().toString().trim().equals("0.0")){
                    limparTela();
                        txtOperacao.setText(txtOperacao.getText().toString()
                                + String.valueOf(lerNum));
                } else{
                    txtOperacao.setText(txtOperacao.getText().toString()
                            + String.valueOf(lerNum));
                }
            }

            //insere ponto decimal
            public void inserePonto(String ponto){
                txtOperacao.setText(txtOperacao.getText().toString() + ponto);
            }

            //Limpar tela
            public void limparTela(){
                txtResultado.setText("");
                txtOperacao.setText("");
            }


    //Funcao operacoes
    public void operacao (String operadores) {
        this.op = operadores;


        if (operadores == "+") {
            op1 = Double.parseDouble(txtOperacao.getText().toString().trim());
            limparTela();
        } else if (operadores == "-") {
            op1 = Double.parseDouble(txtOperacao.getText().toString().trim());
            limparTela();
        } else if (operadores == "*") {
            op1 = Double.parseDouble(txtOperacao.getText().toString().trim());
            limparTela();
        } else if (operadores == "/") {
            op1 = Double.parseDouble(txtOperacao.getText().toString().trim());
            limparTela();
        }
    }

    public void igual(){

        if(!txtOperacao.getText().toString().trim().equals("")) {
            if(op =="+"){
                op2 = op1 + Double.parseDouble(txtOperacao.getText().toString().trim());
            }else if (op == "-"){
                op2 = op1 - Double.parseDouble(txtOperacao.getText().toString().trim());
            } else if(op == "*"){
                op2 = op1 * Double.parseDouble(txtOperacao.getText().toString().trim());
            } else if(op == "/"){
                if(op1 ==0){
                    op2 =0;
                }else {
                    op2 = op1 / Double.parseDouble(txtOperacao.getText().toString().trim());
                }
            }
        }else {
            op2=0;
        }
        txtResultado.setText(String.valueOf(op2));
    }

        //Finalizar aplicacao
        public void FecharApp(){

            AlertDialog.Builder dialog = new AlertDialog.Builder(this);

            dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    com.example.bruno.calculadoraexercicio1.MainActivity.this.finish();
                }
            });

            dialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });

            dialog.setTitle("Fechar");
            dialog.setMessage("Deseja realmente fechar este aplicativo?");
            dialog.setIcon(android.R.drawable.ic_menu_close_clear_cancel);
            dialog.show();
        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializar();
        Listener();

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.b0:
                tecladoNum(0);
                break;

            case R.id.b1:
                tecladoNum(1);
                break;

            case R.id.b2:
                tecladoNum(2);
                break;

            case R.id.b3:
                tecladoNum(3);
                break;

            case R.id.b4:
                tecladoNum(4);
                break;

            case R.id.b5:
                tecladoNum(5);
                break;

            case R.id.b6:
                tecladoNum(6);
                break;

            case R.id.b7:
                tecladoNum(7);
                break;

            case R.id.b8:
                tecladoNum(8);
                break;

            case R.id.b9:
                tecladoNum(9);
                break;

            case R.id.btMais:
                operacao("+");
                break;

            case R.id.btMenos:
                operacao("-");
                break;

            case R.id.btDivid:
                operacao("/");
                break;
            case R.id.btX:
                operacao("*");
                break;

            case R.id.btPonto:
                inserePonto(".");
                break;

            case R.id.btClear:
                limparTela();
                break;

            case R.id.btIgual:
                igual();
                break;
        }
    }
}




