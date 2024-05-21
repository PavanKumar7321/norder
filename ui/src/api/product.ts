import useSWR from 'swr';
import { useMemo } from 'react';

import axios, { fetcher, endpoints } from 'src/utils/axios';

import { IProductItem } from 'src/types/product';

// ----------------------------------------------------------------------

export function useGetProducts() {
  const URL = endpoints.product.list;

  const { data, isLoading, error, isValidating } = useSWR(URL, fetcher);

  const memoizedValue = useMemo(
    () => ({
      products: (data as IProductItem[]) || [],
      productsLoading: isLoading,
      productsError: error,
      productsValidating: isValidating,
      productsEmpty: !isLoading && !data.length,
    }),
    [data, error, isLoading, isValidating]
  );

  return memoizedValue;
}

// ----------------------------------------------------------------------

export function useGetProduct(productId: string) {
  const URL = productId ? `${endpoints.product.details.replace('id', productId)}` : '';

  const { data, isLoading, error, isValidating } = useSWR(URL, fetcher);

  const memoizedValue = useMemo(
    () => ({
      product: data as IProductItem,
      productLoading: isLoading,
      productError: error,
      productValidating: isValidating,
    }),
    [data, error, isLoading, isValidating]
  );

  return memoizedValue;
}

// ----------------------------------------------------------------------

export function useSearchProducts(query: string) {
  const URL = query ? [endpoints.product.search, { params: { query } }] : '';

  const { data, isLoading, error, isValidating } = useSWR(URL, fetcher, {
    keepPreviousData: true,
  });

  const memoizedValue = useMemo(
    () => ({
      searchResults: (data?.results as IProductItem[]) || [],
      searchLoading: isLoading,
      searchError: error,
      searchValidating: isValidating,
      searchEmpty: !isLoading && !data?.results.length,
    }),
    [data?.results, error, isLoading, isValidating]
  );

  return memoizedValue;
}

// ----------------------------------------------------------------------

export async function updateProduct(data: Partial<IProductItem>, productId: string) {
  const URL = endpoints.product.details.replace('id', productId);

  try {
    const response = await axios.put(URL, data);
    return response;
  } catch (error) {
    throw new Error(`Failed to update product: ${error.message}`);
  }
}

// ----------------------------------------------------------------------

export async function createProduct(newProductData: Partial<IProductItem>) {
  const URL = endpoints.product.create;

  try {
    const response = await axios.post(URL, newProductData);
    return response.data;
  } catch (error) {
    throw new Error(`Failed to create a new product: ${error.message}`);
  }
}

// ----------------------------------------------------------------------

export async function deleteProduct(productId: string) {
  const URL = endpoints.product.delete.replace('id', productId);
  try {
    const response = await axios.delete(URL);
    return response.data;
  } catch (error) {
    throw new Error(`Failed to delete a record: ${error.message} `);
  }
}
