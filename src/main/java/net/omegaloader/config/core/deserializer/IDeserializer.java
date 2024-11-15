package net.omegaloader.config.core.deserializer;

import it.unimi.dsi.fastutil.io.FastBufferedInputStream;
import net.omegaloader.config.builder.ConfigSpec;

import java.io.InputStreamReader;
import java.nio.Buffer;

public interface IDeserializer {


    void deserialize(ConfigSpec spec, FastBufferedInputStream reader);

    String serialize(ConfigSpec spec);

    void create2line()

    // LETS DO THIS FUCKERY
    // FIRST PARSE THE WHOLE FILE, STORE THE COMMENTS ON A MAP, KEY AS DOTTED and VALUE (parent.group1.group2.key=value)
    // THEN READ THE WHOLE SPEC AND VALIDATE IF ANY SPEC KEY MATCHES WITH FILE KEYS
    // VALIDATE IF COMMENTS MATCHES (IF NOT, FIX THEM)
    // PARSE THE VALUE
    // DO THE PROPER VALIDATIONS TO FIND IF RANGE, LENGHT AND OTHER STUFF IS CORRECT
    // PARSING FAILED? FALLBACK ON DEFAULT AND WARN ABOUT, IF WAS MATH, VALIDATE IF STRICTMATH IS DISABLED
    // FILE KEYS GETS DROPPED AFTER PARSE THE VALUE
    // MOVE TO NEXT FIELD ON THE SPEC

    // REMAINING FILE KEYS (NOT FOUNDED IN THE SPEC) WILL BE RE-VALIDATED TO FIND THEY "MATCH"
    // ITERATE ALL SPEC (AGAIN)
    // FIND ANY SPEC KEY THAT MATCHES MORE THAN 80% OF THE FILE KEY
    // IF WAS FOUNDED CHECK IF TYPE IS THE EXACT SAME (RENAMED CONFIG)
    // IF TYPE DOESN'T MATCH, CHECK IF TYPE IS A NEIGHTBOR TYPE (Float is Double Neightbor, Int, Long, Short and Byte are also neightbors)
    // IF ARE NEIGHTBORS, PARSE AS NEIGHTBOR'S MORE PRECISE TYPE AND VALIDATE THE FIELD
    // WHEN ALL VALIDATIONS ARE DONE, SET THE VALUE, OTHERWISE IGNORE IT AND SEND FILE KEY TO HELL
}
