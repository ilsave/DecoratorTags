package ru.gushin.ngtu.ivt;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        String path = get_path(); // Пользователь указывает, какой файл он хочет использовать

        // Работа с файлом
        BufferedReader br = null;
        try {
            // Чтение из одного файла
            List<String> list = new LinkedList<>(); // Список, в который читаются все строки файла
            br = new BufferedReader(new FileReader(path));
            String line;
            int num_of_tabs = 0; // Количество табов
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
                list.add(line); // Строка помещается в список всех строк
            }

            // Запись в другой файл с добавлением разметки в функции
            File file = new File("result.txt"); // Обозначаем файл для записи
            if (!file.exists())
                file.createNewFile(); // Если файла нет, то он создается
            PrintWriter pw = new PrintWriter(file);
            PrintInFile(list, file); // Сначала текст записывается в формате .txt
            String result_path = CopyToHTML(file); // Затем создается копия этого файла, но в формате .html

            pw.close();

            System.out.println("Работа успешно завершена!\nЗапись была произведена в файл " + result_path);


        }catch(IOException e){
            e.printStackTrace();
        }
    }

    // Записывает весь список строк в файл, добавляя HTML разметку
    static void PrintInFile(List<String> list, File file){
        String line2 =
                "<head>" +
                        "<title>" +
                        "Hey There!" + // Первая часть разметки
                        "</title>" +
                "</head>" +
                "<body>";
        String line3 =
                "\n" +
                        " </body>\n" + // Вторая часть разметки
                        "</html>";
        try {
            if (!file.exists())
                file.createNewFile();
            PrintWriter pw = new PrintWriter(file);
            pw.print(line2); // Первая часть разметки пишется в файл
            for (String line1 : list){
                pw.print("<br>");
                // Применяем все возможные декораторы для строки и записываем в файл
                pw.print(new FinalDecorator(new PrivateDecorator(new ProtectedDecorator(new PublicDecorator(new StaticDecorator(new VoidDecorator(new ReturnClass(new StringBuilder(line1)))))))).sendBackLine().toString()); // Каждая строка из списка пишется в файл
                pw.println("</br>");
            }
            pw.print(line3); // Вторая часть разметки пишется в файл
            pw.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    // Функция создает копию .txt файла и меняет расширение на .html
    static String CopyToHTML(File source) throws IOException{
        InputStream is = null;
        OutputStream os = null;
        File dest = new File("result.html"); // Файл, куда будет записан html код
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length); // Копирование файла в новый
            }
        } finally {
            is.close();
            os.close();
        }
        return dest.getAbsolutePath().toString(); // Возвращается абсолютный путь к файлу с итоговым рузельтатом
    }


    // Функция возвращает путь к файлу, который пользователь введет
    static String get_path(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Пожалуйста, введите путь к файлу, который вы бы хотели перевести в HTML формат: ");
        String path = reader.nextLine(); // Читается вся строка
        File file = new File(path);
        while (!file.exists()) {
            System.out.println("Такого файла не существует! Попробуйте указать другой путь: ");
            path = reader.nextLine();
            file = new File(path);
        }
        return path;

    }

}

