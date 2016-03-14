# Relative Size Calculation

Program to calculate relative size ranges for very small, small, medium, large, and very large ranges using standard deviation.

## Running Locally

Make sure you have Java and Maven installed.  Also, install the [Heroku Toolbelt](https://toolbelt.heroku.com/).

```sh
$ git clone https://github.com/sanarroya/ECOS-Relative-Size-Calculation.git
$ cd Tarea4
$ mvn clean install
$ heroku local web
```

Your app should now be running on [localhost:5000](http://localhost:5000/).

If you're going to use a database, ensure you have a local `.env` file that reads something like this:

```
DATABASE_URL=postgres://localhost:5432/java_database_name
```

## Heroku

To access the application on heroku go to the following link:

- [Relative size calculation](https://hidden-brook-36984.herokuapp.com/)