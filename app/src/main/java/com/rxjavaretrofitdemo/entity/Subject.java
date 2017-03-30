package com.rxjavaretrofitdemo.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/3/30.
 */

public class Subject {

//    "rating": {"max": 10,
//                "average": 9.6,
//                "stars": "50",
//                "min": 0},
//    "genres": ["\u72af\u7f6a", "\u5267\u60c5"],
//    "title": "\u8096\u7533\u514b\u7684\u6551\u8d4e",
//    "casts": [
//        {"alt": "https:\/\/movie.douban.com\/celebrity\/1054521\/",
//         "avatars": {"small": "https://img3.doubanio.com\/img\/celebrity\/small\/17525.jpg",
//                     "large": "https://img3.doubanio.com\/img\/celebrity\/large\/17525.jpg",
//                    "medium": "https://img3.doubanio.com\/img\/celebrity\/medium\/17525.jpg"},
//         "name": "\u8482\u59c6\u00b7\u7f57\u5bbe\u65af",
//         "id": "1054521"},
//    {"alt": "https:\/\/movie.douban.com\/celebrity\/1054534\/",
//                "avatars": {
//            "small": "https://img3.doubanio.com\/img\/celebrity\/small\/34642.jpg",
//                    "large": "https://img3.doubanio.com\/img\/celebrity\/large\/34642.jpg",
//                    "medium": "https://img3.doubanio.com\/img\/celebrity\/medium\/34642.jpg"
//        },
//        "name": "\u6469\u6839\u00b7\u5f17\u91cc\u66fc",
//                "id": "1054534"
//    },
//    {"alt": "https:\/\/movie.douban.com\/celebrity\/1041179\/",
//                "avatars": {
//            "small": "https://img1.doubanio.com\/img\/celebrity\/small\/5837.jpg",
//                    "large": "https://img1.doubanio.com\/img\/celebrity\/large\/5837.jpg",
//                    "medium": "https://img1.doubanio.com\/img\/celebrity\/medium\/5837.jpg"
//        },
//        "name": "\u9c8d\u52c3\u00b7\u5188\u987f",
//                "id": "1041179"
//    }],
//    "collect_count": 1045201,
//    "original_title": "The Shawshank Redemption",
//    "subtype": "movie",
//    "directors": [
//        {"alt": "https:\/\/movie.douban.com\/celebrity\/1047973\/",
//            "avatars": {"small": "https://img3.doubanio.com\/img\/celebrity\/small\/230.jpg",
//                "large": "https://img3.doubanio.com\/img\/celebrity\/large\/230.jpg",
//                "medium": "https://img3.doubanio.com\/img\/celebrity\/medium\/230.jpg"},
//        "name": "\u5f17\u5170\u514b\u00b7\u5fb7\u62c9\u90a6\u7279",
//        "id": "1047973"}],
//    "year": "1994",
//    "images": {"small": "https://img3.doubanio.com\/view\/movie_poster_cover\/ipst\/public\/p480747492.webp",
//                "large": "https://img3.doubanio.com\/view\/movie_poster_cover\/lpst\/public\/p480747492.webp",
//                "medium": "https://img3.doubanio.com\/view\/movie_poster_cover\/spst\/public\/p480747492.webp"},
//    "alt": "https:\/\/movie.douban.com\/subject\/1292052\/",
//    "id": "1292052"

    private String id;
    private String alt;
    private String year;
    private String title;
    private String subtype;
    private String original_title;
    private String collect_count;
    private List<String> genres;
    private List<Cast> casts;
    private Avatars images;

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public List<Cast> getCasts() {
        return casts;
    }

    public void setCasts(List<Cast> casts) {
        this.casts = casts;
    }

    public String getCollect_count() {
        return collect_count;
    }

    public void setCollect_count(String collect_count) {
        this.collect_count = collect_count;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Avatars getImages() {
        return images;
    }

    public void setImages(Avatars images) {
        this.images = images;
    }

    private class Cast {
        private String id;
        private String name;
        private String alt;
        private Avatars avatars;

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public Avatars getAvatars() {
            return avatars;
        }

        public void setAvatars(Avatars avatars) {
            this.avatars = avatars;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "cast.id=" + id + " cast.name=" + name + "|";
        }
    }

    private class Avatars {
        private String small;
        private String large;
        private String medium;

        public String getLarge() {
            return large;
        }

        public void setLarge(String large) {
            this.large = large;
        }

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }
    }

    @Override
    public String toString() {
        return "subject.id=" + id
                + " subject.alt=" + alt
                + " subject.year=" + year
                + " subject.subtype=" + subtype
                + " subject.original_title=" + original_title
                + " subject.collect_count=" + collect_count;
    }
}
