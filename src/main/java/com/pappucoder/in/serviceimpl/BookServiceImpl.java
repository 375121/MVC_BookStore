package com.pappucoder.in.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pappucoder.in.entity.Books;
import com.pappucoder.in.repository.BookRepository;
import com.pappucoder.in.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	private BookRepository bookRepository;

	public BookServiceImpl(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public List<Books> saveBookDetails(Books book) {
		if (null != book && null != book.getBookId()) {
			Books oldBook= getBookById(book.getBookId());
			oldBook.setAuthorName(book.getAuthorName());
			oldBook.setBookName(book.getBookName());
			oldBook.setBookSerialId(book.getBookSerialId());
			oldBook.setEdition(book.getEdition());
			oldBook.setIsActive(book.getIsActive());
			bookRepository.save(book);
		}else {
			bookRepository.save(book);
		}
		return getAllBookList();
	}

//	@Modifying
//	@Query("UPDATE ApplicationDisbursementDetails SET dedupeId = :dedupId,lastUpdatedDate = CURRENT_TIMESTAMP where applicationKey = :applicationKey")
//	void updateDedupId(@Param("dedupId") String dedupId, @Param("applicationKey") Long applicationKey);
	
	
	@Override
	public List<Books> getAllBookDetails() {
		return getAllBookList();
	}

	@Override
	public List<Books> deleteBook(Long bookId) {
		bookRepository.delete(getBookById(bookId));
		return getAllBookList();
	}

	@Override
	public List<Books> editBook(Books book) {
		return saveBookDetails(book);
	}

	@Override
	public Books getBookById(Long bookId) {
		Optional<Books> findById = bookRepository.findById(bookId);
		return findById.get();
	}

	private List<Books> getAllBookList() {

		return bookRepository.findAll();
	}
}
