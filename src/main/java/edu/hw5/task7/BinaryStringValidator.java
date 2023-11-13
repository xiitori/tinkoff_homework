package edu.hw5.task7;

import java.util.regex.Pattern;

public class BinaryStringValidator {

    private static final Pattern noLess3andThirdSymbolIs3 = Pattern.compile("^([01])([01])0(0|1*)$");

    private static final Pattern firstAndLastSymbolEquals = Pattern.compile("^(0|1)(0|1*)\\1$");

    private static final Pattern noLess1AndNoMore3 = Pattern.compile("^([01]{1,3})$");

    private BinaryStringValidator() {
    }

}
