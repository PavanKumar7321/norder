import useSWR from 'swr';
import { useMemo } from 'react';

import { fetcher, endpoints } from 'src/utils/axios';

import { IUserItem } from 'src/types/user';

// ----------------------------------------------------------------------

export function useGetUsers() {
  const URL = endpoints.user.list;

  const { data, error, isValidating } = useSWR(URL, fetcher);

  const isLoading = !data && !error;

  const memoizedValue = useMemo(
    () => ({
      users: (data as IUserItem[]) || [],
      usersLoading: isLoading,
      usersError: error,
      usersValidating: isValidating,
      usersEmpty: !isLoading && !data.length,
    }), 
    [data, error, isLoading, isValidating]
  );

  return memoizedValue;
}


// ----------------------------------------------------------------------

export function useGetUser(userId: string) {
  const URL = userId ? `${endpoints.user.details.replace('id', userId)}` : '';

  const { data, isLoading, error, isValidating } = useSWR(URL, fetcher);

  const memoizedValue = useMemo(
    () => ({
      user: data as IUserItem,
      userLoading: isLoading,
      userError: error,
      userValidating: isValidating,
    }),
    [data, error, isLoading, isValidating]
  );

  return memoizedValue;
}

// ----------------------------------------------------------------------

// export function useSearchUsers(query: string) {
//   const URL = query ? [endpoints.user.search, { params: { query } }] : '';

//   const { data, isLoading, error, isValidating } = useSWR(URL, fetcher, {
//     keepPreviousData: true,
//   });

//   const memoizedValue = useMemo(
//     () => ({
//       searchResults: (data?.results as IUserItem[]) || [],
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

// export async function updateUser(data: Partial<IUserItem>, userId: string) {
//   const URL = endpoints.user.details.replace('id', userId);

//   try {
//     const response = await axios.put(URL, data);
//     return response;
//   } catch (error) {
//     throw new Error(`Failed to update user: ${error.message}`);
//   }
// }

// // ----------------------------------------------------------------------

// export async function createUser(newUserData: Partial<IUserItem>) {
//   const URL = endpoints.user.create;

//   try {
//     const response = await axios.post(URL, newUserData);
//     return response.data;
//   } catch (error) {
//     throw new Error(`Failed to create a new user: ${error.message}`);
//   }
// }

// // ----------------------------------------------------------------------

// export async function deleteUser(userId: string) {
//   const URL = endpoints.user.delete.replace('id', userId);
//   try {
//     const response = await axios.delete(URL);
//     return response.data;
//   } catch (error) {
//     throw new Error(`Failed to delete a record: ${error.message} `);
//   }
// }
