package org.tonylin.powermock.fields;
class PrivateStaticFinal {
    private static final Integer variable = 0;
    public static Integer method() { return variable + 1; }
}