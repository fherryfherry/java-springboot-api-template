package com.sampleproject.sampleproject.helpers;

import java.text.Normalizer;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Pattern;

public class General {

    public String makeSlug(String input) {
        String noWhiteSpace = Pattern.compile("[\\s]").matcher(input).replaceAll("-");
        String normalized = Normalizer.normalize(noWhiteSpace, Normalizer.Form.NFD);
        String slug = Pattern.compile("[^\\w-]").matcher(normalized).replaceAll("");
        return slug.toLowerCase(Locale.ENGLISH);
    }

    public static int randomNumber(int min, int max)
    {
        Random rn = new Random();
        int range = max - min + 1;
        return rn.nextInt(range) + min;
    }

}
