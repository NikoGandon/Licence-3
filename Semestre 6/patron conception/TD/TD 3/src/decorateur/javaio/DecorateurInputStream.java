package decorateur.javaio;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DecorateurInputStream extends FilterInputStream {

    public DecorateurInputStream(InputStream in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        int data = super.read();

        if (data == -1)
            return -1;

        if (Character.isLetter(data)) {
            data = Character.toLowerCase(data);
        }

        if (data == ',' || data == '|') {
            data = ';';
        }
        return data;
    }
}
