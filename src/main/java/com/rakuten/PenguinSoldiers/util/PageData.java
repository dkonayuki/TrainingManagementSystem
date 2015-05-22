package com.rakuten.PenguinSoldiers.util;

public class PageData {
	public static int defaultPageSize = 10;

	protected final int pageSize;		// all these fields has getter methods
	protected final int firstIndex;
	protected final int lastIndex;
	protected final int totalItems;
	protected final int totalPages;
	protected int currentPage;
	protected final int pageItemsCount;

	/**
	 * Main constructor.
	 * @param page	current page
	 * @param size	total number of items
	 * @param pageSize number of items per page
	 * @param pageItems list of fetched items 
	 */
	public PageData(int page, int size, int pageSize) {
		if (pageSize <= 0) {
			pageSize = defaultPageSize;

		}
		this.pageSize = pageSize;
		this.totalItems = size;
		this.totalPages = (totalItems % pageSize == 0) ? totalItems / pageSize : totalItems / pageSize + 1;
		if (page < 1) {
			page = 1;

		}
		if (page > totalPages) {
			page = totalPages;

		}
		this.currentPage = page;
		this.firstIndex = calcFirstItemIndexOfPage(page, pageSize, size);
		int last = isLastPage() ? totalItems - 1: firstIndex + pageSize - 1;
		int itemsPerPage = last - firstIndex + 1;
		if (last < 0) {
			last = 0;
			itemsPerPage = 0;

		}
		this.lastIndex = last;
		this.pageItemsCount = itemsPerPage;

	}

	public boolean hasNextPage() {
		return currentPage < totalPages;
	}

	public boolean isLastPage() {
		return currentPage == totalPages;

	}

	public int getCurrentPage() {
		return this.currentPage;
	}

	public boolean hasPreviousPage() {
		return currentPage > 1;

	}

	public boolean isFirstPage() {
		return currentPage == 1;
	}

	public int getTotalPages() {
		return this.totalPages;
	}

	// ---------------------------------------------------------------- utilities

	/**
	 * Calculates page number that contains some item.
	 */
	public static int calcPageOfItem(int itemIndex, int pageSize) {
		return itemIndex / pageSize + 1;
	}

	/**
	 * Calculates the first item index of requested page.
	 */
	public static int calcFirstItemIndexOfPage(int page, int pageSize, int total) {
		if (total == 0) {
			return 0;

		}
		if (page < 1) {
			page = 1;

		}
		int first = (page - 1) * pageSize;
		if (first >= total) {
			first = ((total - 1) / pageSize) * pageSize;	// first item on the last page

		}
		return first;

	}

}
