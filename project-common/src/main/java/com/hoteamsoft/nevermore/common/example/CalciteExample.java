package com.hoteamsoft.nevermore.common.example;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.Collections;
import java.util.Map;
import org.apache.calcite.sql.SqlLiteral;
import org.apache.calcite.sql.parser.SqlParserPos;

/**
 * @author Li.Wei by 2023/4/13
 */
public class CalciteExample {

    private static Map<String, String> map() {
        String s = "";
        s = s + "1";
        System.out.println("1");
        System.out.println("1");
        System.out.println("1");
        System.out.println("1");
        System.out.println("1");
        return Collections.EMPTY_MAP;
    }

    //
    public static void main(String[] args) {
        System.out.println(SqlLiteral.createBoolean(false, SqlParserPos.ZERO));
        System.out.println(SqlLiteral.createBoolean(false, SqlParserPos.ZERO));
        System.out.println(SqlLiteral.createBoolean(false, SqlParserPos.ZERO));
        System.out.println(SqlLiteral.createBoolean(false, SqlParserPos.ZERO));
        System.out.println(SqlLiteral.createBoolean(false, SqlParserPos.ZERO));
        System.out.println(SqlLiteral.createBoolean(false, SqlParserPos.ZERO));
    }

    public User deserializeObject(InputStream receivedFile) throws IOException, ClassNotFoundException {

        return (User) new ObjectInputStream(receivedFile).readObject();
    }
}
