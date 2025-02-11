package org.omegaconfig.impl.codecs;

import org.omegaconfig.api.ICodec;

import java.io.File;

public class FileCodec implements ICodec<File> {
    @Override
    public String encode(File instance) {
        return instance.getAbsolutePath();
    }

    @Override
    public File decode(String value) {
        return new File("/").toPath().resolve(value).toFile().getAbsoluteFile();
    }


    @Override
    public Class<File> type() {
        return File.class;
    }
}
