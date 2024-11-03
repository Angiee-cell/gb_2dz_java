// Задание 1. Формирование URL с параметрами
// Дана строка базового URL:
// https://example.com/search?
// Сформируйте полный URL, добавив к нему параметры для поиска. Параметры
// передаются в виде строки, где ключи и значения разделены =, а пары
// ключ-значение разделены &. Если значение null, то параметр не должен
// попадать в URL.
// Пример:
// params = "query=java&sort=desc&filter=null"
// Результат:
// https://example.com/search?query=java&sort=desc


class URLBuilder {
    public static String buildURL(String baseURL, String params) {
    // Введите свое решение ниже

        StringBuilder url = new StringBuilder(baseURL);
        String[] pairs = params.split("&");

        for (int i = 0; i < pairs.length; i++) {
            String[] keyValue = pairs[i].split("=");
            if (!"null".equals(keyValue[1])) {
                if (i > 0) {
                    url.append("&");
                }

url.append(keyValue[0]).append("=").append(keyValue[1]);

            }
        }

        return url.toString();

    }
}
    // Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
    public class task1 {
    public static void main(String[] args) {
    String baseURL = "";
    String params = "";
    if (args.length == 0) {
        // При отправке кода на Выполнение, вы можете варьировать эти параметры
        baseURL = "https://example.com/search?";
        params = "query=java&sort=desc&filter=null";
        } else {
        baseURL = args[0];
        params = args[1];
        }
        URLBuilder ans = new URLBuilder();
        System.out.println(ans.buildURL(baseURL, params));
        }
        }