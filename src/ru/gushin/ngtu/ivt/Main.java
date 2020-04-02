package ru.gushin.ngtu.ivt;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        BufferedReader br = null;  // Далее идет работа с файлом
        try {
            // Чтение из одного файла
            List<String> list = new LinkedList<>(); // Список, в который читаются все строки файла
            br = new BufferedReader(new FileReader("src/ru/gushin/ngtu/ivt/StudentPojo.java"));
            String line;
            List<String> spaces = new LinkedList<>();
            int num_of_tabs = 0; // Количество табов
            boolean in_brackets = false;
            while ((line = br.readLine()) != null) {
                int count_spaces = 0; // Счетчик пробелов
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) != ' ') { // Если встречается не пробел, то цикл завершается
                        break;
                    } else if (line.charAt(i) == ' ') { // Если встречается пробел, то счетчик пробелов увеличивается на 1
                        count_spaces++;
                    }
                }
                StringBuffer buf = new StringBuffer(line);
                for (int j = 0; j < count_spaces; j++) { // В строку вставляется соответствующее количество пробелов в начало
                    buf.insert(0, "&nbsp");
                }
                line = buf.toString();
                list.add(line);
            }

            // Запись в другой файл с добавлением разметки в функции
            File file = new File("try.txt"); // Обозначаем файл для записи
            if (!file.exists())
                file.createNewFile(); // Если файла нет, то он создается
            PrintWriter pw = new PrintWriter(file);
            List<String> tagged_list = Tags(list); // В строки вставляются теги
            PrintInFile(tagged_list, file); // Сначала текст записывается в формате .txt
            CopyToHTML(file); // Затем создается копия этого файла, но в формате .html
            pw.close();




        }catch(IOException e){
            e.printStackTrace();
        }
    }

    // Записывает весь список строк в файл, добавляя HTML разметку
    static void PrintInFile(List<String> list, File file){
        String line2 =
                "<head>" +
                        "<title>" +
                        "Hey There!" +
                        "</title>" +
                "</head>" +
                "<body>";
        String line3 =
                "\n" +
                        " </body>\n" +
                        "</html>";
        try {
            if (!file.exists())
                file.createNewFile();
            PrintWriter pw = new PrintWriter(file);
            pw.print(line2); // Первая часть разметки пишется в файл
            for (String line1 : list){
                pw.print("<br>");
                pw.print(line1); // Каждая строка из списка пишется в файл
                pw.println("</br>");
            }
            pw.print(line3); // Вторая часть разметки пишется в файл
            pw.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    // Функция создает копию .txt файла и меняет расширение на .html
    static void CopyToHTML(File source) throws IOException{
        InputStream is = null;
        OutputStream os = null;
        File dest = new File("try.html"); // Файл, куда будет записан html код
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }


    // Функция размещает HTML теги около ключевых слов
    static List<String> Tags(List<String> list){
        List<String> tagged_list = new LinkedList<>(); // Список строк с тегами.
        for (String line: list){
            boolean was_modefied = false; // показывает, была ли изменена строка
            String tag_line = line;
            String[] words = line.split(" "); // строка разбивается на слова
            for (String word: words){
                // Если в строке есть ключевое слово, то мы добавляем к нему теги и записваем новую строку в лист
                if (word.equals("public")){
                    ReturnInterface retInt1 = new PublicDecorator(new ReturnClass(new StringBuilder(tag_line)));
                    tag_line = retInt1.sendBackLine().toString();
                    was_modefied = true;

                }
                else if (word.equals("protected")){
                    ReturnInterface retInt1 = new ProtectedDecorator(new ReturnClass(new StringBuilder(tag_line)));
                    tag_line = retInt1.sendBackLine().toString();
                    was_modefied = true;

                }
                else if (word.equals("private")){
                    ReturnInterface retInt1 = new PrivateDecorator(new ReturnClass(new StringBuilder(tag_line)));
                    tag_line = retInt1.sendBackLine().toString();
                    was_modefied = true;

                }
                else if (word.equals("static")){
                    ReturnInterface retInt1 = new StaticDecorator(new ReturnClass(new StringBuilder(tag_line)));
                    tag_line = retInt1.sendBackLine().toString();
                    was_modefied = true;

                }
                else if (word.equals("void")){
                    ReturnInterface retInt1 = new VoidDecorator(new ReturnClass(new StringBuilder(tag_line)));
                    tag_line = retInt1.sendBackLine().toString();
                    was_modefied = true;

                }
                else if (word.equals("final")){
                    ReturnInterface retInt1 = new FinalDecorator(new ReturnClass(new StringBuilder(tag_line)));
                    tag_line = retInt1.sendBackLine().toString();
                    was_modefied = true;

                }

            }
            // Если ключевых слов нет, то мы записываем строку не измененной
            if (!was_modefied){
                tagged_list.add(line);
            }
            // А если теги были добавлены, то записываем измененную строку
            else{
                tagged_list.add(tag_line);
            }
        }
        System.out.println("\n\n\nTAGGED_LIST");
        for (String line:tagged_list){
            System.out.println(line);
        }

        return tagged_list;
    }

}

