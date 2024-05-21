import useSWR from 'swr';
import { useMemo } from 'react';

import axios, { fetcher, endpoints } from 'src/utils/axios';

import { IInvoice } from 'src/types/invoice';

// ----------------------------------------------------------------------

export function useGetInvoices() {
  const URL = endpoints.invoice.list;

  const { data, isLoading, error, isValidating } = useSWR(URL, fetcher);

  const memoizedValue = useMemo(
    () => ({
      invoices: (data as IInvoice[]) || [],
      invoicesLoading: isLoading,
      invoicesError: error,
      invoicesValidating: isValidating,
      invoicesEmpty: !isLoading && !data.length,
    }),
    [data, error, isLoading, isValidating]
  );

  return memoizedValue;
}

// ----------------------------------------------------------------------

export function useGetInvoice(invoiceId: string) {
  const URL = invoiceId ? `${endpoints.invoice.details.replace('id', invoiceId)}` : '';

  const { data, isLoading, error, isValidating } = useSWR(URL, fetcher);

  const memoizedValue = useMemo(
    () => ({
      invoice: data as IInvoice,
      invoiceLoading: isLoading,
      invoiceError: error,
      invoiceValidating: isValidating,
    }),
    [data, error, isLoading, isValidating]
  );

  return memoizedValue;
}

// ----------------------------------------------------------------------

// export function useSearchProducts(query: string) {
//   const URL = query ? [endpoints.invoice.search, { params: { query } }] : '';

//   const { data, isLoading, error, isValidating } = useSWR(URL, fetcher, {
//     keepPreviousData: true,
//   });

//   const memoizedValue = useMemo(
//     () => ({
//       searchResults: (data?.results as IInvoiceItem[]) || [],
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

export async function deleteInvoice(invoiceId: string) {
  const URL = endpoints.invoice.delete.replace('id', invoiceId);
  try {
    const response = await axios.delete(URL);
    return response.data;
  } catch (error) {
    throw new Error(`Failed to delete a record: ${error.message} `);
  }
}
