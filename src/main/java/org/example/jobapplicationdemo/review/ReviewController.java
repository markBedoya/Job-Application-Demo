package org.example.jobapplicationdemo.review;

import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/companies/{companyId}/reviews")
public class ReviewController {

  private ReviewService reviewService;

  @GetMapping
  public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId) {
    return new ResponseEntity<>(reviewService.getAllReviewsByCompanyId(companyId), HttpStatus.OK);
  }

  @GetMapping("/{reviewId}")
  public ResponseEntity<Review> getReviewById(@PathVariable Long companyId,
      @PathVariable Long reviewId) {
    Optional<Review> review = reviewService.getReviewByCompanyIdReviewId(companyId, reviewId);
    return review.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @PostMapping
  public ResponseEntity<String> createReview(@PathVariable Long companyId,
      @RequestBody Review review) {
    return reviewService.createCompanyReview(companyId, review) ?
        new ResponseEntity<>("Review created successfully", HttpStatus.CREATED) :
        new ResponseEntity<>("Review not created.", HttpStatus.NOT_FOUND);
  }

  @PutMapping("/{reviewId}")
  public ResponseEntity<String> updateReview(@PathVariable Long companyId,
      @PathVariable Long reviewId, @RequestBody Review updatedReview) {
    return reviewService.updateReviewById(companyId, reviewId, updatedReview) ?
        new ResponseEntity<>("Review updated successfully", HttpStatus.OK) :
        new ResponseEntity<>("Review not updated.", HttpStatus.NOT_FOUND);
  }

  @DeleteMapping("/{reviewId}")
  public ResponseEntity<String> deleteReview(@PathVariable Long companyId,
      @PathVariable Long reviewId) {
    return reviewService.deleteReviewById(companyId, reviewId) ?
        new ResponseEntity<>("Review deleted successfully", HttpStatus.OK) :
        new ResponseEntity<>("Review not deleted", HttpStatus.NOT_FOUND);
  }

}
