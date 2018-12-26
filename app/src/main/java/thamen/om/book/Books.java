package thamen.om.book;
/**
 * Created by sasmob on 12/12/2018.
 */

public class Books {

        private String author;
        private String title;
        private String description;
        private Source source;

        private  String image ;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }



        public void setSource(Source source) {
            this.source = source;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }



