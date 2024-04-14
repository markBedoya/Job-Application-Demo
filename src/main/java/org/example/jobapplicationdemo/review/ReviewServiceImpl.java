package org.example.jobapplicationdemo.review;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import org.example.jobapplicationdemo.company.Company;
import org.example.jobapplicationdemo.company.CompanyService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {

  private ReviewDao reviewRepository;
  private CompanyService companyService;

  @Override
  public List<Review> getAllReviewsByCompanyId(Long companyId) {
    return reviewRepository.findByCompanyId(companyId);
  }

  @Override
  public Optional<Review> getReviewByCompanyIdReviewId(Long companyId, Long reviewId) {
    return Stream.ofNullable(getAllReviewsByCompanyId(companyId))
        .flatMap(Collection::stream)
        .filter(Objects::nonNull)
        .filter(r -> r.getId().equals(reviewId)).findFirst();
  }

  @Override
  public boolean createCompanyReview(Long companyId, Review review) {
    Optional<Company> companyOptional = companyService.getCompanyById(companyId);
    if (companyOptional.isEmpty()) {
      return false;
    }
    review.setCompany(companyOptional.get());
    reviewRepository.save(review);
    return true;
  }

  @Override
  public boolean updateReviewById(Long companyId, Long reviewId, Review updatedReview) {
    Optional<Company> companyOptional = companyService.getCompanyById(companyId);
    if (companyOptional.isEmpty()) {
      return false;
    }
    updatedReview.setCompany(companyOptional.get());
    updatedReview.setId(reviewId);
    reviewRepository.save(updatedReview);
    return true;
  }

  @Override
  public boolean deleteReviewById(Long companyId, Long reviewId) {
    Optional<Company> companyOptional = companyService.getCompanyById(companyId);
    Optional<Review> reviewOptional = reviewRepository.findById(reviewId);
    if (companyOptional.isEmpty() || reviewOptional.isEmpty()) {
      return false;
    }
    Review review = reviewOptional.get();
    Company company = companyOptional.get();
    //TODO - understand this bidirectional mapping and why this is required to remove the review
    // from company and I can't just delete it.
    review.setCompany(null);
    company.getReviews().remove(review);
    companyService.updateCompanyById(company.getId(),company);
    reviewRepository.deleteById(reviewId);
    return true;
  }

}
