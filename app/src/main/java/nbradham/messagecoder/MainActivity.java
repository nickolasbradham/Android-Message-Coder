package nbradham.messagecoder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void encode(View view) {
        shiftChars(getShift());
    }

    public void decode(View view) {
        shiftChars(-getShift());
    }

    private byte getShift() {
        return Byte.parseByte(((EditText) findViewById(R.id.shiftNum)).getText().toString());
    }

    private void shiftChars(int shift) {
        char[] message = ((EditText) findViewById(R.id.inputField)).getText().toString().toCharArray();
        for (byte i = 0; i < message.length; i++)
            if (Character.isAlphabetic(message[i]))
                message[i] = (char) (Math.floorMod(Character.toLowerCase(message[i]) - 'a' + shift, 26) + 'a');
        ((TextView) findViewById(R.id.outputField)).setText(new String(message));
    }
}