package decorateur.javaio;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DecorateurWriter extends FilterWriter {

    public DecorateurWriter(Writer out) {
        super(out);
    }

    @Override
    public void write(String str, int off, int len) throws IOException {
        
    }

}
