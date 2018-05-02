package poupana.devandroid.com.poupana;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText valorInicial;
    private EditText aplicacaoMensal;
    private EditText tempoAplicacao;
    private EditText taxa;
    private Button botaoCalcular;
    private TextView resultadoCalc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valorInicial = (EditText) findViewById(R.id.valorInicialId);
        aplicacaoMensal = (EditText) findViewById(R.id.aplicacaoMensalId);
        tempoAplicacao = (EditText) findViewById(R.id.tempoAplicacaoID);
        taxa = (EditText) findViewById(R.id.taxaId);
        botaoCalcular = (Button) findViewById(R.id.botaoCalcularId);
        resultadoCalc = (TextView) findViewById(R.id.resultadoCalcId);

        botaoCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Recuperar o que foi digitado
                String txtDigitadoVI = valorInicial.getText().toString();
                String txtDigitadoAM = aplicacaoMensal.getText().toString();
                String txtDigitadoTA = tempoAplicacao.getText().toString();
                String txtDigitadoT = taxa.getText().toString();

                double num_ValorInicial = Double.parseDouble(txtDigitadoVI);
                double num_AplicacaoMensal = Double.parseDouble(txtDigitadoAM);
                double num_TempoAPlicacao = Double.parseDouble(txtDigitadoTA);
                double num_Taxa = Double.parseDouble(txtDigitadoT);
                double resultadoFinal = 0;
                double resultadoParcial = 0;
                double rendimento = 0;

                if ( txtDigitadoVI.isEmpty() | txtDigitadoAM.isEmpty() | txtDigitadoTA.isEmpty() | txtDigitadoT.isEmpty() ){
                    resultadoCalc.setText("Preecha todos os campos!!");
                }else{
                    for (int i = 0; i < num_TempoAPlicacao; i++) {
                        if (i == 0){
                            rendimento = (num_ValorInicial * num_Taxa) / 100;
                            resultadoFinal = num_ValorInicial + rendimento;
                        }else {
                            rendimento = ((resultadoFinal + num_AplicacaoMensal) * num_Taxa) / 100;
                            resultadoFinal = resultadoFinal + num_AplicacaoMensal + rendimento;
                        }
                    }
                    resultadoFinal = Double.valueOf(String.format("%.2f", resultadoFinal));
                    resultadoCalc.setText("R$"+resultadoFinal);
                };
            }
        });

    }
}
