import useSWR from 'swr';
import { useMemo } from 'react';

import axios, { fetcher, endpoints } from 'src/utils/axios';

import { IOrderItem } from 'src/types/order';

// ----------------------------------------------------------------------

export function useGetOrders() {
  const URL = endpoints.order.list;

  const { data, isLoading, error, isValidating } = useSWR(URL, fetcher);

  const memoizedValue = useMemo(
    () => ({
      orders: (data as IOrderItem[]) || [],
      ordersLoading: isLoading,
      ordersError: error,
      ordersValidating: isValidating,
      ordersEmpty: !isLoading && !data.length,
    }),
    [data, error, isLoading, isValidating]
  );

  return memoizedValue;
}

// ----------------------------------------------------------------------

export function useGetOrder(orderId: string) {
  const URL = orderId ? `${endpoints.order.details.replace('id', orderId)}` : '';

  const { data, isLoading, error, isValidating } = useSWR(URL, fetcher);

  const memoizedValue = useMemo(
    () => ({
      order: data as IOrderItem,
      orderLoading: isLoading,
      orderError: error,
      orderValidating: isValidating,
    }),
    [data, error, isLoading, isValidating]
  );

  return memoizedValue;
}

// ----------------------------------------------------------------------

// export function useSearchProducts(query: string) {
//   const URL = query ? [endpoints.order.search, { params: { query } }] : '';

//   const { data, isLoading, error, isValidating } = useSWR(URL, fetcher, {
//     keepPreviousData: true,
//   });

//   const memoizedValue = useMemo(
//     () => ({
//       searchResults: (data?.results as IOrderItem[]) || [],
//       searchLoading: isLoading,
//       searchError: error,
//       searchValidating: isValidating,
//       searchEmpty: !isLoading && !data?.results.length,
//     }),
//     [data?.results, error, isLoading, isValidating]
//   );

//   return memoizedValue;
// }

// // ----------------------------------------------------------------------

// export async function updateProduct(data: Partial<IProductItem>, productId: string) {
//   const URL = endpoints.product.details.replace('id', productId);

//   try {
//     const response = await axios.put(URL, data);
//     return response;
//   } catch (error) {
//     throw new Error(`Failed to update product: ${error.message}`);
//   }
// }

// // ----------------------------------------------------------------------

// export async function createProduct(newProductData: Partial<IProductItem>) {
//   const URL = endpoints.product.create;

//   try {
//     const response = await axios.post(URL, newProductData);
//     return response.data;
//   } catch (error) {
//     throw new Error(`Failed to create a new product: ${error.message}`);
//   }
// }

// // ----------------------------------------------------------------------

export async function deleteOrder(orderId: string) {
  const URL = endpoints.order.delete.replace('id', orderId);
  try {
    const response = await axios.delete(URL);
    return response.data;
  } catch (error) {
    throw new Error(`Failed to delete a record: ${error.message} `);
  }
}
