# CAPD Common Play Templates

This is a repository for common play [twirl](https://github.com/playframework/twirl) templates used across multiple Play applications in CAPD.

## Usage

Edit the *.scala.html files under src/main/twirl, update the version.sbt and compile/publish the project:

```
# local
./sbt publish-local

# global
./sbt publish
```

Reference the templates library in your play applications Build.scala:

```
object ApplicationBuild extends Build {
  ...
  val appDependencies = Seq (
    javaCore,
    ...
    "uk.gov.defra" % "capd-common-play-templates" % "0.1.0",
    ...
  )
  ...
```

Templates are available to play applications referencing the library like normal templates:

```
public class Application extends Controller {
  public static Result index() {
    return ok(uk.gov.defra.capd.templates.html.test.render("test"));
  }
}
```

Or use instead your own play application templates:

```
@()

@uk.gov.defra.capd.templates.html.main(title = "Countryside Stewardship") {
...
}
```

## Note

* Removed cookie notification logic as no access to play, changed to boolean params which need to be set in Frontend applications own view by looking at Request cookies
    - General
    - unsupported browsers
* Removed angularJS userType logic and replaced with userType string param which need to be set in Frontend applications own view by looking at Request Header

* Feedback - taking the same approach as external auth and removing the links for feedback
* Signout - redirect to my account and open sign out
* Internal User name in header - extract callerId from req header and get name info

## TODO

### Outstanding

* Google Analytics - all over
* Internal User name in header - header_top_internal.scala.html
* Cookie notification dismissal JS - main


### De-duplicate

Moved the following from these repos, so they need to be refactored to remove them and replace with common.

From capd-frontends:

* main.scala.html
* phase_notice
* unsupported_browsers
* header_bar
* footer

Look at internal auth, external auth