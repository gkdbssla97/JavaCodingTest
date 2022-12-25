package syntax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Study_Input_Output {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        System.out.println(stringTokenizer.nextToken());
        System.out.println(stringTokenizer.nextToken());
        System.out.println(stringTokenizer.nextToken());
        System.out.println(Arrays.toString(s));
    }
}
